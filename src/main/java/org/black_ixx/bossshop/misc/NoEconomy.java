package org.black_ixx.bossshop.misc;

import java.util.List;

import org.black_ixx.bossshop.managers.ClassManager;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class NoEconomy implements Economy{

	@Override
	public EconomyResponse bankBalance(String arg0) {
		System.out.print("No Economy Plugin found!");
		return null;
	}

	@Override
	public EconomyResponse bankDeposit(String arg0, double arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse bankHas(String arg0, double arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse bankWithdraw(String arg0, double arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse createBank(String arg0, String arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public boolean createPlayerAccount(String arg0) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public boolean createPlayerAccount(String arg0, String arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public String currencyNamePlural() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public String currencyNameSingular() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse deleteBank(String arg0) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, double arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse depositPlayer(String arg0, String arg1, double arg2) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public String format(double arg0) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public int fractionalDigits() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return 0;
	}

	@Override
	public double getBalance(String arg0) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return 0;
	}

	@Override
	public double getBalance(String arg0, String arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return 0;
	}

	@Override
	public List<String> getBanks() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public String getName() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public boolean has(String arg0, double arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public boolean has(String arg0, String arg1, double arg2) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public boolean hasAccount(String arg0) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public boolean hasAccount(String arg0, String arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public boolean hasBankSupport() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public EconomyResponse isBankMember(String arg0, String arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse isBankOwner(String arg0, String arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public boolean isEnabled() {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return false;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, double arg1) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

	@Override
	public EconomyResponse withdrawPlayer(String arg0, String arg1, double arg2) {
		ClassManager.manager.getBugFinder().warn("No Economy Plugin was found... You need one if you want to work with Money! Get it there: http://plugins.bukkit.org/.");
		return null;
	}

}