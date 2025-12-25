package baiTapTrenLop;

import java.util.Scanner;

public class Product implements IShop {

    // ===== ATTRIBUTES =====
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    // ===== CONSTRUCTORS =====
    public Product() {
    }

    public Product(String productId, String productName, float price,
                   String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    // ===== GETTER & SETTER =====
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    // ===== INPUT DATA =====
    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct,
                          Categories[] arrCategories, int indexCatalog) {

        // PRODUCT ID
        while (true) {
            System.out.print("Nhập mã sản phẩm (Cxxx/Sxxx/Axxx): ");
            String id = scanner.nextLine();

            if (!id.matches("[CSA][A-Za-z0-9]{3}")) {
                System.out.println("Sai định dạng mã!");
                continue;
            }

            boolean isExist = false;
            for (int i = 0; i < indexProduct; i++) {
                if (arrProduct[i].productId.equalsIgnoreCase(id)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                this.productId = id;
                break;
            } else {
                System.out.println("Mã sản phẩm bị trùng!");
            }
        }

        // PRODUCT NAME
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();

            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên sản phẩm từ 10–50 ký tự!");
                continue;
            }

            boolean isExist = false;
            for (int i = 0; i < indexProduct; i++) {
                if (arrProduct[i].productName.equalsIgnoreCase(name)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                this.productName = name;
                break;
            } else {
                System.out.println("Tên sản phẩm bị trùng!");
            }
        }

        // PRICE
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            float p = Float.parseFloat(scanner.nextLine());

            if (p > 0) {
                this.price = p;
                break;
            } else {
                System.out.println("Giá phải lớn hơn 0!");
            }
        }

        // DESCRIPTION
        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        // CHOOSE CATEGORY
        System.out.println("Danh mục hiện có:");
        for (int i = 0; i < indexCatalog; i++) {
            System.out.println(arrCategories[i].getCatalogId() + " - " +
                    arrCategories[i].getCatalogName());
        }

        System.out.print("Nhập mã danh mục: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());

        // STATUS
        while (true) {
            System.out.print("Nhập trạng thái (0-Bán | 1-Hết | 2-Không bán): ");
            int status = Integer.parseInt(scanner.nextLine());

            if (status >= 0 && status <= 2) {
                this.productStatus = status;
                break;
            } else {
                System.out.println("Chỉ được nhập 0, 1 hoặc 2!");
            }
        }
    }

    // ===== DISPLAY =====
    @Override
    public void displayData() {
        String statusStr = productStatus == 0 ? "Đang bán"
                : productStatus == 1 ? "Hết hàng" : "Không bán";

        System.out.println("Mã SP: " + productId +
                " | Tên: " + productName +
                " | Giá: " + price +
                " | Danh mục: " + catalogId +
                " | Trạng thái: " + statusStr);
    }
}