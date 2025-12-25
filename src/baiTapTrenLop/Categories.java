package baiTapTrenLop;


import java.util.Scanner;

public class Categories implements IShop {

    // ===== ATTRIBUTES =====
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    // ===== CONSTRUCTORS =====
    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // ===== GETTER & SETTER =====
    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // ===== INPUT DATA =====
    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {

        // AUTO INCREMENT ID
        int maxId = 0;
        for (int i = 0; i < index; i++) {
            if (arrCategories[i].catalogId > maxId) {
                maxId = arrCategories[i].catalogId;
            }
        }
        this.catalogId = maxId + 1;

        // INPUT NAME
        while (true) {
            System.out.print("Nhập tên danh mục: ");
            String name = scanner.nextLine();

            if (name.length() == 0 || name.length() > 50) {
                System.out.println("Tên danh mục tối đa 50 ký tự!");
                continue;
            }

            boolean isExist = false;
            for (int i = 0; i < index; i++) {
                if (arrCategories[i].catalogName.equalsIgnoreCase(name)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                this.catalogName = name;
                break;
            } else {
                System.out.println("Tên danh mục bị trùng!");
            }
        }

        // DESCRIPTION
        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = scanner.nextLine();

        // STATUS
        while (true) {
            System.out.print("Nhập trạng thái (true/false): ");
            String status = scanner.nextLine();

            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            } else {
                System.out.println("Chỉ được nhập true hoặc false!");
            }
        }
    }

    // ===== DISPLAY =====
    @Override
    public void displayData() {
        System.out.println("Mã DM: " + catalogId +
                " | Tên DM: " + catalogName +
                " | Mô tả: " + descriptions +
                " | Trạng thái: " + (catalogStatus ? "Hoạt động" : "Không hoạt động"));
    }
}