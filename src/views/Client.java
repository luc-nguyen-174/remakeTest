package views;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static List<Material> materials = new ArrayList<>();
    public static MaterialManager materialManager = new MaterialManager(materials);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Material flour1 = new CrispyFlour("F001", "Bột Chiên Giòn 1", LocalDate.of(2022, 11, 01), 5000, 2);
        Material flour2 = new CrispyFlour("F002", "Bột Chiên Giòn 2", LocalDate.of(2022, 11, 05), 6000, 3);
        Material flour3 = new CrispyFlour("F003", "Bột Chiên Giòn 3", LocalDate.of(2022, 11, 10), 7000, 4);
        Material flour4 = new CrispyFlour("F004", "Bột Chiên Giòn 4", LocalDate.of(2022, 11, 15), 8000, 5);
        Material flour5 = new CrispyFlour("F005", "Bột Chiên Giòn 5", LocalDate.of(2022, 11, 20), 9000, 6);

        Material meat1 = new Meat("M001", "Thịt Heo 1", LocalDate.of(2022, 11, 01), 30000, 2);
        Material meat2 = new Meat("M002", "Thịt Heo 2", LocalDate.of(2022, 11, 05), 35000, 3);
        Material meat3 = new Meat("M003", "Thịt Heo 3", LocalDate.of(2022, 11, 10), 40000, 4);
        Material meat4 = new Meat("M004", "Thịt Heo 4", LocalDate.of(2022, 11, 15), 45000, 5);
        Material meat5 = new Meat("M005", "Thịt Heo 5", LocalDate.of(2022, 11, 20), 50000, 6);

        materialManager.addMaterial(flour1);
        materialManager.addMaterial(flour2);
        materialManager.addMaterial(flour3);
        materialManager.addMaterial(flour4);
        materialManager.addMaterial(flour5);

        materialManager.addMaterial(meat1);
        materialManager.addMaterial(meat2);
        materialManager.addMaterial(meat3);
        materialManager.addMaterial(meat4);
        materialManager.addMaterial(meat5);
        int select;
        //menu
        do {
            System.out.print("Menu\n");
            System.out.print("""
                    1. Hien thi
                    2. Them san pham
                    3. Sua san pham
                    4. Xoa san pham""");
            System.out.print("\nMoi ban chon:");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    materialManager.display();
                    break;
                case 2:
                    materialManager.addMaterial(createMaterial());
                    break;
                case 3:

                case 4:

                case 0:
                    System.exit(0);
            }
        } while (select != 0);
    }

    public static Material createMaterial() {
        System.out.print("Nhap ID: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.print("Nhap ngay san xuat (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        LocalDate manufacturingDate = LocalDate.parse(dateString);
        System.out.print("Nhap gia: ");
        int cost = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Day la bot hay thit? (bot)/(thit): ");
        String type = scanner.nextLine();
        if (type.equals("bot")) {
            System.out.print("Nhap so luong: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            return new CrispyFlour(id, name, manufacturingDate, cost, quantity);
        } else if (type.equals("thit")) {
            System.out.print("nhap can nang: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            return new Meat(id, name, manufacturingDate, cost, weight);
        } else return null;
    }

}