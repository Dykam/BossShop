package org.black_ixx.bossshop.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.black_ixx.bossshop.BossShop;
import org.black_ixx.bossshop.managers.ClassManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class BSShop {


	//////////////////////////// <- Variables

	private String shop_name = "BossShop";
	private String sign_text = "[BossShop]";

	private String displayname;

	private boolean needPermToCreateSign = true;

	private boolean customizable = false;
	private boolean hiding = false;
	private boolean displaying = false;

	private int inventory_size = 9;
	private int shop_id = 0;

	private Inventory inventory;

	private HashMap<ItemStack, BSBuy> shop_items = new LinkedHashMap<ItemStack, BSBuy>();

	//////////////////////////// <- Constructor

	public BSShop(int shop_id, String shop_name, String sign_text, boolean needPermToCreateSign, BossShop plugin, String displayname){
		this.shop_id=shop_id;
		this.shop_name=shop_name;
		this.sign_text=sign_text;
		this.needPermToCreateSign=needPermToCreateSign;
		hiding = plugin.getClassManager().getSettings().getInventoryCustomizingHideEnabled();

		setDisplayName(displayname);
	}

	public BSShop(int shop_id){
		this.shop_id=shop_id;
	}

	//////////////////////////// <- Methods to get main Variables

	public String getShopName(){
		return shop_name;
	}

	public String getDisplayName(){
		return displayname; 
	}

	public String getSignText(){
		return sign_text;
	}

	public boolean needPermToCreateSign(){
		return needPermToCreateSign;
	}

	public boolean isCustomizable(){
		return customizable;
	}

	public int getInventorySize(){
		return inventory_size;
	}

	public int getShopId(){
		return shop_id;
	}

	public Inventory getInventory(){
		return inventory;
	}

	//////////////////////////// <- Methods to set main Variables

	public void setShopName(String name){
		shop_name=name;
	}

	public void setSignText(String text){
		sign_text=text;
	}

	public void setNeedPermToCreateSign(boolean b){
		needPermToCreateSign=b;
	}

	public void setCustomizable(boolean b){
		customizable=b;
	}

	public void setDisplayName(String displayname){
		if(displayname!=null){
			this.displayname=ClassManager.manager.getStringManager().transform(displayname);
		}else{
			this.displayname=shop_name;
		}
	}

	//////////////////////////// <- Methods to get Items

	public HashMap<ItemStack, BSBuy> getItems(){
		return shop_items;
	}

	public BSBuy getShopItem(ItemStack item){
		for (ItemStack i : shop_items.keySet()){
			if(i.getType()==item.getType()){
				if(i.getAmount()==item.getAmount()){
					if(i.getDurability()==item.getDurability()){
						if(i.hasItemMeta()&&item.hasItemMeta()|!i.hasItemMeta()&!item.hasItemMeta()){
							if(i.hasItemMeta()){

								if(i.getItemMeta().hasDisplayName()!=item.getItemMeta().hasDisplayName()|| i.getItemMeta().hasLore()!=item.getItemMeta().hasLore()){
									continue;
								}

								if(i.getItemMeta().hasLore()){
									if(i.getItemMeta().getLore().size()!=item.getItemMeta().getLore().size()){
										continue;
									}
									int x = 0;
									for (String line : i.getItemMeta().getLore()){
										if(!line.equalsIgnoreCase(item.getItemMeta().getLore().get(x))){
											continue;
										}
										x++;
									}
								}

								if(i.getItemMeta().hasDisplayName()){
									if(!i.getItemMeta().getDisplayName().equalsIgnoreCase(item.getItemMeta().getDisplayName())){
										continue;
									}}

								return shop_items.get(i);


							}else{
								return shop_items.get(i);
							}
						}
					}
				}
			}
		}
		return null;
	}

	public ItemStack getMenuItem(BSBuy buy){
		for (ItemStack item : shop_items.keySet()) {
			BSBuy b = shop_items.get(item);
			if(b!=null){
				if(b==buy){
					return item;
				}
			}
		}
		return null;
	}

	//////////////////////////// <- Other Methods

	public void addShopItem(BSBuy buy, ItemStack menu_item, ClassManager manager){

		if(hiding){
			if(!customizable){
				if(buy.isExtraPermissionExisting()){
					customizable=true;
				}
			}
		}

		if(!customizable){
			for (ItemStack i : shop_items.keySet()){
				BSBuy bb = shop_items.get(i);
				if(bb!=null){
					if(bb.getInventoryLocation()==buy.getInventoryLocation()){
						customizable=true;
						break;
					}
				}
			}
		}

		if(menu_item.hasItemMeta()){
			ItemMeta meta = menu_item.getItemMeta();
			if (meta.hasDisplayName()){
				String st = buy.transformMessage(meta.getDisplayName());
				meta.setDisplayName(st);			

				if(st.contains("%balance%")||st.contains("%balancepoints%")){
					customizable=true;
					displaying=true;
				}

			}
			if (meta.hasLore()){
				List<String> list = meta.getLore();
				List<String> l = new ArrayList<String>();
				for (String s : list){
					l.add(buy.transformMessage(s));
				}
				if (l!=null&&l.size()>0){
					meta.setLore(l);

					for(String lore_line : l){
						if(lore_line.contains("%balance%")||lore_line.contains("%balancepoints%")){
							customizable=true;
							displaying=true;
						}
					}

				}
			}
			menu_item.setItemMeta(meta);
		}

		shop_items.put(menu_item, buy);
	}

	public void removeItem(int inv_loc){
		List<ItemStack> to_remove = new ArrayList<ItemStack>();

		for(ItemStack i : shop_items.keySet()){
			BSBuy buy = shop_items.get(i);
			if(buy.getInventoryLocation()==inv_loc){
				to_remove.add(i);				
			}
		}
		for(ItemStack i : to_remove){
			shop_items.remove(i);
		}
		if(inventory!=null){
			inventory.setItem(inv_loc, null);
		}
	}

	public void createInventory(){

		BSShopHolder holder = new BSShopHolder(this);
		inventory = Bukkit.createInventory(holder, inventory_size, displayname);

		HashMap<Integer, BSBuy> locs = new HashMap<Integer, BSBuy>();

		for (ItemStack item : shop_items.keySet()){
			BSBuy b = shop_items.get(item);
			if(b!=null){
				locs.put(b.getInventoryLocation(), b);
				inventory.setItem(b.getInventoryLocation(), item);
			}
		}

		holder.setItems(locs);

	}

	public Inventory createInventory(Player p, ClassManager manager){
		if(!customizable){
			if(inventory==null){
				createInventory();
			}
			return inventory;
		}

		return manager.getShopCustomizer().createInventory(this, shop_items, displaying, p, manager);

	}

	public void updateInventory(Inventory i, Player p, ClassManager manager){
		manager.getShopCustomizer().createInventory(this, shop_items, displaying, p, manager, i);
	}

	public void loadInventorySize(){
		int highest = 0;
		for (ItemStack item : shop_items.keySet()){
			BSBuy b = shop_items.get(item);
			if(b!=null){
				if(b.getInventoryLocation()>highest){
					highest=b.getInventoryLocation();
				}
			}
		}
		inventory_size=getInventorySize(highest);
	}

	public int getInventorySize(int i){
		i++;

		int size = 9;

		if(i>9){
			size=18;
		}

		if(i>18){
			size=27;
		}

		if(i>27){
			size=36;
		}

		if(i>36){
			size=45;
		}

		if(i>45){
			size=54;
		}

		if(i>54){
			size=63;
		}

		if(i>63){
			size=72;
		}

		if(i>72){
			size=81;
		}
		return size;
	}

	public void openInventory(Player p){
		if(!customizable){
			if(inventory!=null){
				p.openInventory(inventory);
				return;
			}			
		}
		p.openInventory(createInventory(p, ClassManager.manager));
	}
	
	public void close(){
		if(inventory!=null){
			for (HumanEntity h : inventory.getViewers()){
				h.closeInventory();
			}
		}
	}

	//////////////////////////// <- Load Methods

	public void finishedAddingItems(){
		loadInventorySize();
		if(!customizable){
			createInventory();
		}
	}
	
	//////////////////////////// <- Abstract

	public abstract void reloadShop();
	





}
