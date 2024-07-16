package view;

import util.ScanUtil;

public class Print {
	public void var() {
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}
	public void var1() {
		System.out.println("▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰");
	}
	public void var1PrintLn() {
		printLn(1);
		var1();
	}
	public void menuPrint() {
		System.out.println("\t\t\t\t\t\t     ╔══════════════════════════════════════════════╗");
		printLn(1);
	}
	public void spacePrint() {
		System.out.print("\t\t\t\t\t\t\t\t\t");
	}
	public void spacePrint1() {
		System.out.print("\t\t\t\t\t\t\t\t");
	}
	public void spacePrint2() {
		System.out.print("\t\t\t\t\t\t\t");
	}
	public void printLn(int num) {
		for(int i = 0; i < num; i++)System.out.println();
	}
	public void mainPrint1() {
		System.out.println("\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢀⣠⣴⣶⠿⠿⠿⠿⣶⣦⣄⠀⠀⠀ ⢀⣤⣶⡾⠿⠿⠿⠿⣶⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠛⠁⠀⠀⠀⠀⠀⠀⠈⠻⣿⣆⢀⣴⡿⠋⠁⠀⠀⠀⠀⠀⠀ ⠉⠻⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠁⠀⢀⣤⣶⠿⠿⣶⣄⠀⠀⠈⢿⣿⡟⠀⠀⢀⣴⡾⠿⠿⣶⣄⠀⠀⠘⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣿⡇⠀⠀⢸⣿⠁⠀⠀⠈⣿⡇⠀⠀⢸⣿⠀⠀⠀⣾⣿⠀⠀⠀⢸⣿⡆⠀⠀  ⢹⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣧⠀⠀⠈⠿⣷⣤⣤⣾⠟⠁⠀⠀⣼⣿⣆⠀⠀⠘⢿⣶⣤⣴⣾⠟⠀⠀⢀⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣧⣀⠀⠀⠀⠉⠉⠀⠀⠀⣠⣾⡟⠙⢿⣦⡀⠀⠀⠈⠉⠉⠀⠀⠀⣠⣾⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⣤⣤⣤⣽⣿⣷⣶⣤⣤⣤⣴⣶⣿⣿⣭⣤⣤⣤⣽⣿⣷⣶⣤⣤⣤⣴⣶⣿⣿⣥⣤⣤⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⢹⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠛⠿⣶⣤⣀⠀⠀⠀⠀⣿⡿⠛⠛⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠉⠛⠿⣷⣤⣄⣿⡇⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠉⠛⣿⡇⠀⠀ ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀         ⠀  ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⣿⡇⠀⠀ ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀        ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⣿⡇⠀⠀ ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⡇⠀⠀ ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⢀⣠⣴⣶⠿⠛⠉  ⣿⡇⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣾⠿⠛⠉⠀⠀⠀⠀⠀⠿⠿⠿⠿⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"\t\t\t⠀⣤⣤⣤⣤⠀⣤⣤⣤⣤⠀⠀⠀⢠⣤⣤⣤⣤⡄⠀⠀⠀⠀⣠⣤⣤⣤⣀⠀⠀⠀⠀⠀⣤⣤⣤⣤⡄⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⡀⠀⠀⠀ ⠀⣤⣤⣤⠀⠀⠀⢠⣤⣤⡀⢠⣤⣤⠀⠀⠀⢠⣤⣤⣤⣤⡄⠀⠀⠀⣤⣤⣤⣤⠀⣤⣤⣤⣤⠀⠀⠀⠀⢠⣤⣤⣤⣤⠀⠀\r\n" + 
				"\t\t\t⠀⣿⣿⣿⣿⠀⣿⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⣾⣿⣿⢿⣿⣿⡆⠀⠀⠀⠀⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⢠⣿⣿⡿⢿⣿⣿⡀⠀⠀⠀⣿⣿⣿⠀⠀⠀⢸⣿⣿⣇⢸⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⣿⣿⣿⣿⡆⣿⣿⣿⣿⠀⠀⠀⠀⣸⣿⣿⣿⣿⠀⠀\r\n" + 
				"\t\t\t⠀⣿⣿⣿⣿⣧⣿⣿⣿⣿⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⣿⣿⣿⠸⣿⣿⣿⠀⠀⠀⢠⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⢸⣿⣿⡇⠀⠀⠀⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⢸⣿⣿⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀ ⠀⣿⣿⣿⣿⣇⣿⣿⣿⣿⠀⠀⠀⠀⣿⣿⣿⣿⣿⡄⠀\r\n" + 
				"\t\t\t⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⣿⣿⣿⣤⣤⣤⣤⠀⠀⠀⢸⣿⣿⢸⣿⣿⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠘⠛⠛⠃⠀⠀⠀⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⣿⣿⡏⣿⣿⡇⠀\r\n" + 
				"\t\t\t⠀⣿⣿⡇⣿⣿⣿⣿⣿⣿⠀⠀⠀⢸⣿⣿⡟⠛⠃⠀⠀⠀⣿⣿⣿⠛⣿⣿⣿⠀⠀⠀⣼⣿⣿⣸⣿⣿⡆⠀⠀⠀⠀⠀⢸⣿⣿⡇⢠⣤⣤⡄⠀⠀⠀⣿⣿⣿⠀⠀⠀⢸⣿⣿⢻⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⠛⠃⠀⠀⠀⣿⣿⣿⢻⣿⣿⢸⣿⣿⠀⠀⠀⢰⣿⣿⣇⣿⣿⣧⠀\r\n" + 
				"\t\t\t⠀⣿⣿⡇⢹⣿⡿⢸⣿⣿⠀⠀⠀⢸⣿⣿⣇⣀⡀⠀⠀⠀⣿⣿⣿⢀⣿⣿⣿⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⢸⣿⣿⡇⣸⣿⣿⠇⠀⠀⠀⣿⣿⣿⠀⠀⠀⢸⣿⣿⠘⣿⣿⣿⠀⠀⠀⢸⣿⣿⣿⣀⣀⠀⠀⠀⣿⣿⣿⢸⣿⣿⢸⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⠀\r\n" + 
				"\t\t\t⠀⣿⣿⡇⢸⣿⡇⢸⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⠀⣿⣿⣿⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⠟⠀⠀⠀⠀⣿⣿⣿⠀⠀ ⠀⢸⣿⣿⠀⢿⣿⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⢸⣿⡟⢸⣿⣿⠀⠀⠀⣼⣿⣿⡇⢻⣿⣿⡀\r\n" + 
				"\t\t\t⠀⠉⠉⠁⠈⠉⠁⠈⠉⠉⠀⠀⠀⠀⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠉⠉⠀⠉⠁⠀⠀ ⠀⠉⠉⠁⠀⠉⠉⠉⠀⠀⠀⠀⠀⠀ ⠀⠈⠉⠉⠁⠀⠀⠀⠀⠀⠉⠉⠉⠀  ⠀ ⠈⠉⠉⠀⠈⠉⠉⠀⠀⠀  ⠉⠉⠉⠉⠉⠀⠀⠀ ⠉⠉⠉⠈⠉⠁⠈⠉⠉⠀⠀⠀⠈⠉⠉⠀⠈⠉⠉⠁\r\n" + 
				"");
		var1();
		printLn(3);
		spacePrint1();
		System.out.println("1. 로그인");
		spacePrint1();
		System.out.println("2. 회원가입");
		printLn(2);
	}
	public void loginPrint() {
		printLn(1);
		var1();
		printLn(5);
		spacePrint1();
		System.out.println("[ 로그인 하십시오 ]");
		printLn(5);
	}
	public void loginIssue() {
		printLn(1);
		var1();
		printLn(5);
		spacePrint2();
		System.out.println("[ ID 혹은 PW를 잘못 입력 하셨습니다 ]");
   	    DelayUtil.delay(2000);
		printLn(1);
		spacePrint1();
		System.out.println("1. 재로그인");
		spacePrint1();
		System.out.println("2. 회원가입");
		spacePrint1();
		System.out.println("3. 초기 화면으로");
		printLn(5);
	}
	public void signUpPrint() {
		printLn(1);
		var1();
		printLn(5);
		spacePrint1();
		System.out.println("회원가입 화면입니다");
		spacePrint1();
		System.out.println("개인 정보를 입력해주세요");
		printLn(5);
	}
	public void adminPrint(String memName) {
		printLn(1);
		var1();
		printLn(5);
		spacePrint1();
		System.out.println("[ 환영합니다! " + memName + "님  ]	");
		System.out.println();
		spacePrint1();
		System.out.println("1. 예매화면으로");
		spacePrint1();
		System.out.println("2. 마이페이지");
		spacePrint1();
		System.out.println("3. 로그아웃");
		printLn(5);
	}
	public void movieListPirnt() {
		printLn(1);
		var1();
		printLn(5);
		System.out.println("\t\t\t\t\t번호\t영화제목\t\t\t장르\t\t관람가\t     상영관");
		var();
	}
	public void movieListReturnPrint() {
		var();
	    System.out.println("\t\t\t\t\t5   뒤로가기");
	    printLn(1);
	}
	public void movieDetailPrint(String movieName, String genre, String rateType) {
		var();
		System.out.println("영화제목\t\t장르\t  관람가");
		printLn(1);
		System.out.println(movieName + "\t" + genre + "\t  " + rateType);
		printLn(1);
		System.out.println("1. 영화스케쥴 조회");
		System.out.println("2. 영화리스트(뒤로가기)");
		printLn(1);
	}
	// 1번영화
	public void movieDetailPrint1(String movieName, String genre, String rateType) {
		printLn(1);
		var1();
		System.out.println("\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢟⡟⠛⠂⣘⣿⣿⣿⣿⣿⠿⠟⠛⠋⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⠉⢤⢱⣢⣧⣶⣾⣿⣏⠉⠉⣿⡄⠀⠀⠠⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢛⠿⠛⢲⠻⡀⣘⢠⣿⣷⣾⣿⠿⠛⠛⠛⠛⢿⠀⠀⢘⣿⡇⠀⢀⡿⠟⠛⠋⠁⢘⣿⠛⠛⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⣭⣶⣿⣿⡋⠉⠘⣿⣿⠃⠀⣠⣴⣤⡀⠀⠡⠀⠀⢿⡇⠀⠀⢀⣀⣠⣴⠶⠚⠁⠀⣰⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⠿⠛⢿⣿⣿⣿⠿⢿⣿⣿⠛⠉⢙⣿⣿⣧⠀⠀⠿⠿⠀⠀⣿⣿⣿⡇⠀⠈⡄⠀⠨⣧⠶⠾⠛⠉⠉⠀⢀⣀⣤⣾⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⡿⠋⠀⢀⣠⣿⣿⡄⠀⠨⣿⣿⣧⠀⠀⢿⣿⣿⡄⠀⠀⣀⡄⠀⠈⠛⠟⠁⠀⣸⣿⠀⠀⠁⢀⣀⣠⣴⠶⠟⠛⠛⠿⣿⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⠀⠀⣰⠋⠀⠀⠀⠛⠀⠀⢹⣿⣿⠀⠀⠀⠻⣿⣿⠀⠀⢹⣿⣶⣤⣀⣀⠤⠞⠛⠿⣧⣶⣾⡿⠋⠀⢀⣀⣤⣤⠀⠀⠸⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⠀⠀⢿⣷⣿⣷⠀⠀⣇⠀⠀⣿⠿⠀⠀⣀⠀⠀⠀⢂⠀⠀⣿⣿⡿⠉⠀⢀⣀⡀⠀⠉⣿⣿⠁⠀⠀⣿⣿⣿⣿⣆⠀⠀⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⣄⠀⠀⠛⠛⠋⠀⣰⣿⡀⠀⢀⠀⢀⣴⣿⣿⣿⣿⣿⡖⠚⢙⣿⠃⠀⠰⣿⣿⣿⠀⠀⢸⣿⣧⣠⣴⣾⣿⣿⡿⠃⠀⢀⣾⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣶⣦⣄⣀⠤⣶⣿⣿⡷⠞⠛⢻⣿⣿⠟⠛⠛⠛⠿⣷⠀⠀⢿⣧⠀⠀⠙⠛⠉⠀⢀⣾⣿⠿⣿⣿⠟⠋⠀⢀⣀⣴⣾⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⠀⠀⠋⠉⠁⠀⢀⣠⣴⡿⠁⠀⣠⣤⡀⠀⠉⡄⠀⠈⠀⢷⣤⣤⣀⠤⠔⠋⠉⠀⢈⣿⠁⠀⢠⣾⣿⣿⣿⠿⠿⠛⠻⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⢀⣀⣤⣴⣾⣿⣿⣿⣿⠃⠀⠸⣿⣿⣿⠀⠀⢸⠀⠀⠹⠛⠉⠀⢀⡀⠀⣰⣶⣿⣿⣿⡀⠀⠈⠟⠛⠉⠀⢀⣀⣤⣼⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠛⠿⠛⠀⢀⣼⣧⠀⠘⣴⣶⣾⣿⡆⠉⠁⠛⠛⠛⠉⣷⢀⣀⣠⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀⣀⣀⣤⣾⣿⠃⠀⢰⣿⡿⠿⠋⠀⢀⣤⣤⣤⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + 
				"						⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣴⣿⣿⣧⣀⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n" + 
				"");
		var();
		System.out.println("						영화제목\t\t장르\t  관람가");
		printLn(1);
		System.out.println("						"+movieName + "\t" + genre + "\t  " + rateType);
		var();
		printLn(1);
		System.out.println("						1. 영화스케쥴 조회");
		System.out.println("						2. 영화리스트(뒤로가기)");
		printLn(1);
	}
	// 탈주
	public void movieDetailPrint2(String movieName, String genre, String rateType) {
		printLn(1);
		var1();
		System.out.println("\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⢀⣴⣾⣿⣷⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⠀⢸⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⢠⣦⣤⣀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡜⢿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⡟⣰⣿⣿⣿⡿⠿⣿⣿⣿⣿⣿⠃⠀⠉⢉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⣀⣀⠉⠉⣰⣿⣿⣿⡟⣰⣿⣿⣿⣿⣿⣿⣿⣦⣴⣿⣷⣄⠀⠀⠀⠀⠀⠀⢀⣠⣤⣶⣦\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⣰⣿⣿⡟⣼⣿⣿⣿⠟⠀⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⣠⣴⣾⣿⣿⣿⣿⠟\r\n" + 
				"						⠀⠀⠀⠀⠀⠰⣿⣿⣿⣄⡛⠿⢛⣡⣾⣿⣷⣶⣤⣤⡀⢉⣿⣿⡿⠋⠙⢿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠿⠿⣿⣿⣿⣿⣿⣿⡿⢀⣾⠟⠋⠀⠀⠀⠀⠈⠻⠿⠿⠛⠉⠁⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣽⣿⣿⣿⣷⣾⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⣾⣿⡿⣰⣶⣤⣄⣀⠀⠀⣠⣿⣿⣿⣿⣿⠟⠙⢿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⣸⣿⣿⢣⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⠋⠀⠀⠀⠹⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⣼⣿⡿⠋⠘⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠛⠛⠁⠀⠀⠀⠀⠀⠉⠙⠛⠿⠿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⠿⣣⣀⣠⣤⡄⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣫⣵⣾⣿⣿⣿⠟⠁⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⠟⠋⠉⠀⠀⠀⠀⠀⠀\r\n" + 
				"");
		var();
		System.out.println("						영화제목\t\t장르\t  관람가");
		printLn(1);
		System.out.println("						"+movieName + "\t" + genre + "\t  " + rateType);
		printLn(1);
		System.out.println("						1. 영화스케쥴 조회");
		System.out.println("						2. 영화리스트(뒤로가기)");
		printLn(1);
	}
	public void movieDetailPrint3(String movieName, String genre, String rateType) {
		printLn(1);
		var1();
		System.out.println("\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢰⣶⣶⢶⢦⢦⣶⣶⣶⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⡀⠀⣀⢀⠀⡀⠀⡀⡀⠀⢀⠀⢀⢀⠀⡀⡀⡀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠁⠀⠀⠐⠁⠁⠀⠀⠃⠀⠀⠀⠈⠈⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠅⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⣀⣀⣀⡀⠀⠀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⡧⠀⠀⠀⠀⠀⠀⠀⠀⣿⠉⠉⠉⠉⠉⠉⠛⢶⣤⣿⠉⠉⣿⡆⠀⠀⢰⡏⠉⠉⣿⡆⠀⣼⡏⠉⠉⣿⣴⠟⠉⠉⠉⠉⠉⠉⢻⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⣿⠆⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⢠⣤⣤⡀⠀⠈⣿⣿⠀⠀⣿⡇⠀⠀⢸⡇⠀⠀⣿⡇⠀⣿⡇⠀⠀⣿⡏⠀⠀⣠⣤⣤⣤⣤⣼⠇⠀⠀⠀⠀⠀⠀⠀⢐⠀⠀\r\n" + 
				"						⠀⠀⣿⣦⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠸⠿⠿⠃⠀⢠⣿⣿⠀⠀⣿⡇⠀⠀⢸⡇⠀⠀⣿⡇⠀⣿⡇⠀⠀⣿⡇⠀⠀⠿⠿⠿⠿⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⣽⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣧⠀⠀⠀⠀⠀⠀⣿⠀⠀⢀⣀⣀⡀⠈⠙⣿⣿⠀⠀⣿⡇⠀⠀⢸⡇⠀⠀⣿⡇⠀⣿⡇⠀⠀⣿⡇⠀⠀⠀⢀⣀⣀⣸⣿⠀⠀⠀⠀⠀⠀⡀⣰⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣄⡀⠀⠀⠀⢸⣿⠀⠀⢸⣿⣿⡿⠀⠀⢸⣿⠀⠀⢿⣧⣤⣤⣼⡇⠀⠀⢿⣧⣤⣿⠇⠀⠀⣿⡇⠀⠀⣿⣿⣿⣿⣿⣥⡀⠀⠀⠀⠈⠀⣲⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣦⠀⠀⠀⢸⣿⠀⠀⠈⠉⠉⠀⠀⢀⣾⣿⠀⠀⠈⠉⠉⠉⠉⣿⣄⠀⠀⠉⠉⠁⠀⠀⣼⣿⣧⠀⠀⠈⠉⠉⠉⠉⢹⡇⠀⠀⠀⠀⣸⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣀⠀⠘⣿⣶⣶⣶⣶⣶⣶⣾⣿⣿⡿⢿⣶⣶⣶⣶⣶⣶⣿⣿⣿⣶⣶⣶⣶⣶⡿⠻⣿⣿⣿⣶⣶⣶⣶⣶⣶⡾⠃⠀⠀⢀⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣿⣧⣀⣀⠈⠛⠿⠿⠿⠿⠟⠛⠋⠀⠀⠙⠛⠛⠛⠛⠛⠋⠈⠙⠛⠛⠛⠛⠋⠀⠀⠈⠛⠿⠿⠿⠿⠿⠛⠉⠀⠀⢀⣬⣿⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣄⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠠⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣴⡀⡀⠐⠶⠶⠶⠰⠀⠀⠂⠀⠖⠴⠴⠒⠰⠐⠴⠶⠶⠂⠀⠀⣀⣐⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣾⢾⡿⡷⢶⠶⣷⢷⠖⠿⢾⢷⣿⣿⣟⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"						⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\r\n" + 
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"");
		var();
		System.out.println("						영화제목\t\t장르\t  관람가");
		printLn(1);
		System.out.println("						"+movieName + "\t" + genre + "\t  " + rateType);
		printLn(1);
		System.out.println("						1. 영화스케쥴 조회");
		System.out.println("						2. 영화리스트(뒤로가기)");
		printLn(1);
	}
	public void movieDetailPrint4(String movieName, String genre, String rateType) {
		printLn(1);
		var1();
		System.out.println("\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"						⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"					⠀⠀⠀⠀⣀⣠⣤⣤⣀⡀⢠⣤⣤⢤⣤⡄⠀⠀⠀⣤⣤⡄⠀⠀⠀⠀⣤⣤⡄⢠⣤⣤⣤⣤⣤⣤⣤⢠⣤⣤⠀⠀⠀⣀⣤⣤⣤⢠⡀⠀⢠⣤⣤⠀⢠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀\r\n" + 
				"					⠀⠀⠀⠀⠿⢿⣿⣿⠿⠿⢸⣿⣿⣸⣿⡇⠀⠀⣰⣿⣿⣧⣤⠀⣶⣶⣿⣿⡇⠘⠛⠛⠛⢛⣿⣿⡿⢸⣿⣿⠀⠀⣸⣿⡿⠟⠋⣸⣿⡆⢸⣿⣿⠀⠘⠛⠛⠛⣻⣿⣿⠛⠛⠛⠛⠃⠀⠀⠀⠀\r\n" + 
				"					⠀⠀⠀⠀⣴⣿⡿⣿⣷⣄⢸⣿⣿⣿⣿⡇⠀⢠⣿⣿⠛⣿⣿⣆⠉⠉⣿⣿⡇⠀⠀⠀⠀⣾⣿⡟⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⠀⠻⣿⡇⢸⣿⣿⠀⠀⠀⠀⣴⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀\r\n" + 
				"					⠀⠀  ⠐⣿⣿⣇⣿⣿⡿⢸⣿⣿⢻⣿⡇⢀⣾⣿⠏⠀⠘⣿⣿⡆⠀⣿⣿⡇⠀⠀⠀⣼⣿⡿⠁⠀⢸⣿⣿⣿⠀⣿⣿⡇⠀⠀⣾⣿⡇⢸⣿⣿⠀⠀⠀⣼⣿⣿⠃⠘⣿⣿⣧⠀⠀⠀⠀⠀⠀\r\n" + 
				"					⠀⠀⠀⠀⠈⠻⠿⠿⠛⠁⢸⣿⣿⣽⣿⡇⠀⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⢰⡄⠀⠀⣸⣿⣿⠁⠀⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⠀⣾⣿⡇⢸⣿⣿⠀⠀⣼⣿⡿⠁⠀⠀⠈⢿⣿⣧⠀⠀⠀⠀⠀\r\n" + 
				"					⠀⠀⠀⠀⢸⣿⣿⣤⣤⣤⣤⣤⣤⣤⣤⡄⠀⣿⣿⣯⣭⣭⣭⣭⣭⣽⣿⢸⡇⠀⣰⣿⣿⠃⠀⠀⠀⢸⣿⣿⠀⠀⢹⣿⣷⡄⣴⣿⣿⠇⢸⣿⣿⠀⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⠀⠀⠀⠀\r\n" + 
				"					⠀⠀⠀⠀⠸⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠇⠀⠿⠿⠿⠿⠿⠿⠻⠻⠿⠟⠸⠃⠀⠛⠛⠃⠀⠀⠀⠀⠸⠛⠿⠀⠀⠀⠙⠉⠸⠟⠛⠁⠀⠘⠻⠻⠀⠻⠻⠿⠿⠿⠿⠿⠿⠿⠿⠿⠟⠀⠀⠀⠀\r\n" + 
				"");
		var();
		System.out.println("						영화제목\t\t장르\t  관람가");
		printLn(1);
		System.out.println("						"+movieName + "\t" + genre + "\t  " + rateType);
		printLn(1);
		System.out.println("						1. 영화스케쥴 조회");
		System.out.println("						2. 영화리스트(뒤로가기)");
		printLn(1);
	}
	public void schedulePrint() {
		var1();
		printLn(1);
		var();
		System.out.println("\t\t\t상영번호\t1TIME\t\t2TIME\t\t3TIME\t\t4TIME\t\t5TIME\t\t6TIME");
		System.out.print("\t\t\t러닝타임");
		
	}
	public void scheduleDetailPrint() {
		printLn(1);
		var1();
		printLn(1);
	}
	public void scheduleDetailPrint1() {
		printLn(1);
		System.out.println("\t\t\t\t\t\t\t\t╔════════════════╗");
		System.out.println("\t\t\t\t\t\t\t\t║     SCREEN     ║");
		System.out.println("\t\t\t\t\t\t\t\t﻿╚════════════════╝");
		printLn(1);
	}
	public void bookingPrint(String movieName, String genre, String rateType, String seat) {
		printLn(1);
		var1();
		printLn(3);
		spacePrint1();
		System.out.println("╭─────────────────────╮");
		spacePrint1();
		System.out.println("   영화 제목 : " + movieName);
		spacePrint1();
		System.out.println("   장르 : " + genre);
		spacePrint1();
		System.out.println("   관람가 : " + rateType);
		spacePrint1();
		System.out.println("   좌석번호 : " + seat);
		spacePrint1();
		System.out.println("╰─────────────────────╯");
		printLn(1);
	    spacePrint1();
		System.out.println("1. 결제하기");
		spacePrint1();
		System.out.println("2. 메인으로 돌아가기");
		printLn(3);
	}
	public void movieInfoPrint() {
		var1PrintLn();
		printLn(3);
		spacePrint1();
	    System.out.println("[  결제확인 페이지  ]");
	    printLn(3);
	}
	public void ticketBuyPrint() {
		printLn(1);
		spacePrint1();
		System.out.println("결제하실 방법을 선택하세요");
		spacePrint1();
		System.out.println("1. 카드");
		spacePrint1();
		System.out.println("2. 현금");
		spacePrint1();
		System.out.println("3. 삼성페이");
		spacePrint1();
		System.out.println("4. 예매취소");
		printLn(3);
	}
	public void memberDetailPrint(String memName, String memId, String memPass, String memBir, String memNick) {
		printLn(1);
		var1();
		printLn(2);
		spacePrint1();
		System.out.println("[  마이 페이지  ]");
		printLn(2);
		spacePrint1();
		System.out.println("내 정보");
		spacePrint1();
		System.out.println("이름 : " + memName);
		spacePrint1();
		System.out.println("닉네임 : " + memNick);
		spacePrint1();
		System.out.println("ID : " + memId);
		spacePrint1();
		System.out.println("PW : " + memPass);
		spacePrint1();
		System.out.println("생년월일 : " + memBir);
		printLn(4);
		spacePrint1();
		System.out.println("1. 개인정보 수정");
		spacePrint1();
		System.out.println("2. 예매 화면으로");
		spacePrint1();
		System.out.println("3. 예매내역");
		spacePrint1();
		System.out.println("4. 로그아웃");
		spacePrint1();
		System.out.println("5. 회원탈퇴");
		printLn(5);
	}
	public void memberUpdatePrint() {
		printLn(1);
		var1();
		printLn(2);
		spacePrint1();
		System.out.println("[  개인정보 변경 페이지  ]");
		printLn(2);
		spacePrint1();
		System.out.println("변경할 정보를 선택해주세요");
		System.out.println();
		spacePrint1();
		System.out.println("1. 닉네임");
		spacePrint1();
		System.out.println("2. 비밀번호");
		spacePrint1();
		System.out.println("3. 전체");
		spacePrint1();
		System.out.println("4. 마이페이지(돌아가기)");

		printLn(5);
	}
	public void memberUpdateCompletePrint() {
		var();
		spacePrint1();
		System.out.println("[  개인정보가 수정되었습니다 다시 로그인해주십시오  ]");
		spacePrint1();
		System.out.println("[  2초 후 초기 화면으로 이동합니다");
   	    DelayUtil.delay(2000);
	    printLn(3);
		
	}
	public void memberDelte() {
		printLn(1);
		var1();
		printLn(5);
		spacePrint1();
		System.out.println("정말 탈퇴하시겠습니까?");
		spacePrint1();
	    System.out.println("1. 네");
		spacePrint1();
	    System.out.println("2. 아니오");
	    printLn(5);
	}
	public void errorIssuePrint() {
		spacePrint1();
		System.out.println("[ 잘못된 입력값입니다 다시 입력해주십시오 ] ");
   	    DelayUtil.delay(2000);
	}
	public void ticketCheckPrint() {
		printLn(1);
		var1();
		printLn(5);
		spacePrint1();
		System.out.println("1. 예매내역 확인");
		spacePrint1();
		System.out.println("2. 마이페이지로 돌아가기");
		printLn(5);
	}
	public void ticketEmptyPrint() {
		printLn(1);
		var1();
		printLn(5);
		spacePrint1();
		System.out.println("[  예매내역이 없습니다  ]");
   	    DelayUtil.delay(2000);
		spacePrint1();
		System.out.println("[  마이페이지로 이동합니다  ]");
   	    DelayUtil.delay(1000);
		printLn(5);
	}
	public void ticketDetail(String movieName, String runningTime, String rowNum, int seatNum, String theName, String partType) {
		printLn(1);
		
		spacePrint1();
		System.out.println("╭─────────────────────╮");
		printLn(1);
		spacePrint1();
		System.out.println("          "+movieName+"\t");
		spacePrint1();
		System.out.println("      "+theName+", "+partType+"\t");
		spacePrint1();
		System.out.println("      "+runningTime+"\t");
		spacePrint1();
		System.out.println("      "+rowNum+"열 "+seatNum+"번\t");
		printLn(1);
		spacePrint1();
		System.out.println("╰─────────────────────╯");
	}
	public void thankPrint() {
		printLn(3);
		spacePrint2();
		System.out.println("결제가 완료되었습니다. 이용해주셔서 감사합니다");
		spacePrint2();
	    System.out.println("티켓 내역 확인은 마이페이지에서 확인 가능합니다");
	    spacePrint2();
	    System.out.println("3초 후 초기 화면으로 돌아갑니다");
   	    DelayUtil.delay(3000);
	    printLn(3);
	}
}
