package baiTapTrenLop;
import baiTapTrenLop.Categories;
import baiTapTrenLop.Product;

import java.util.Scanner;

public class ShopManagement {

    static Categories[] arrCategories = new Categories[100];
    static Product[] arrProducts = new Product[100];
    static int catalogCount = 0;
    static int productCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n********** SHOP MENU **********");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categoriesMenu(scanner);
                    break;
                case 2:
                    productMenu(scanner);
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }

    // ===================== CATEGORIES MENU =====================
    static void categoriesMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n********** CATEGORIES MENU **********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCategories(scanner);
                    break;
                case 2:
                    showCategories();
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
                    break;
                case 5:
                    updateCategoryStatus(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }

    static void addCategories(Scanner scanner) {
        System.out.print("Nhập số danh mục cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrCategories[catalogCount] = new Categories();
            arrCategories[catalogCount].inputData(scanner, arrCategories, catalogCount);
            catalogCount++;
        }
    }

    static void showCategories() {
        if (catalogCount == 0) {
            System.out.println("Chưa có danh mục nào!");
            return;
        }
        for (int i = 0; i < catalogCount; i++) {
            arrCategories[i].displayData();
        }
    }

    static int findCategoryIndexById(int id) {
        for (int i = 0; i < catalogCount; i++) {
            if (arrCategories[i].getCatalogId() == id) {
                return i;
            }
        }
        return -1;
    }

    static void updateCategory(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(id);

        if (index == -1) {
            System.out.println("Danh mục không tồn tại!");
            return;
        }

        while (true) {
            System.out.println("\n--- UPDATE CATEGORY ---");
            System.out.println("1. Cập nhật tên danh mục");
            System.out.println("2. Cập nhật mô tả");
            System.out.println("3. Thoát");
            System.out.print("Chọn thuộc tính cần sửa: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    arrCategories[index].setCatalogName(scanner.nextLine());
                    System.out.println("✔ Đã cập nhật tên!");
                    break;
                case 2:
                    System.out.print("Nhập mô tả mới: ");
                    arrCategories[index].setDescriptions(scanner.nextLine());
                    System.out.println("✔ Đã cập nhật mô tả!");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
    static void deleteCategory(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(id);

        if (index == -1) {
            System.out.println("Danh mục không tồn tại!");
            return;
        }

        // Kiểm tra danh mục có sản phẩm không
        for (int i = 0; i < productCount; i++) {
            if (arrProducts[i].getCatalogId() == id) {
                System.out.println("Danh mục đang chứa sản phẩm - KHÔNG THỂ XÓA!");
                return;
            }
        }

        for (int i = index; i < catalogCount - 1; i++) {
            arrCategories[i] = arrCategories[i + 1];
//            catalogCount--;
        }
        arrCategories[--catalogCount] = null;
        System.out.println("Xóa danh mục thành công!");
    }

    static void updateCategoryStatus(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần đổi trạng thái: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findCategoryIndexById(id);

        if (index == -1) {
            System.out.println("Danh mục không tồn tại!");
            return;
        }

        arrCategories[index].setCatalogStatus(!arrCategories[index].isCatalogStatus());
        System.out.println("Đã đổi trạng thái!");
    }

    // ===================== PRODUCT MENU =====================
    static void productMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n********** PRODUCT MANAGEMENT **********");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá");
            System.out.println("4. Cập nhật sản phẩm theo mã");
            System.out.println("5. Xóa sản phẩm theo mã");
            System.out.println("6. Tìm kiếm sản phẩm theo tên");
            System.out.println("7. Tìm sản phẩm theo khoảng giá");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProducts(scanner);
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    sortProductsByPrice();
                    break;
                case 4:
                    updateProduct(scanner);
                    break;
                case 5:
                    deleteProduct(scanner);
                    break;
                case 6:
                    searchProductByName(scanner);
                    break;
                case 7:
                    searchProductByPrice(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }

    static void addProducts(Scanner scanner) {
        System.out.print("Nhập số sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrProducts[productCount] = new Product();
            arrProducts[productCount].inputData(scanner, arrProducts, productCount,
                    arrCategories, catalogCount);
            productCount++;
        }
    }

    static void showProducts() {
        if (productCount == 0) {
            System.out.println("Chưa có sản phẩm!");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            arrProducts[i].displayData();
        }
    }

    static void sortProductsByPrice() {
        for (int i = 0; i < productCount - 1; i++) {
            for (int j = i + 1; j < productCount; j++) {
                if (arrProducts[i].getPrice() > arrProducts[j].getPrice()) {
                    Product temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    static int findProductIndexById(String id) {
        for (int i = 0; i < productCount; i++) {
            if (arrProducts[i].getProductId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    static void updateProduct(Scanner scanner) {

        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        int index = findProductIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        while (true) {
            System.out.println("\n--- UPDATE PRODUCT ---");
            System.out.println("1. Cập nhật tên sản phẩm");
            System.out.println("2. Cập nhật giá");
            System.out.println("3. Cập nhật mô tả");
            System.out.println("4. Cập nhật danh mục");
            System.out.println("5. Cập nhật trạng thái");
            System.out.println("6. Thoát");
            System.out.print("Chọn thuộc tính cần sửa: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    arrProducts[index].setProductName(scanner.nextLine());
                    System.out.println("✔ Đã cập nhật tên!");
                    break;

                case 2:
                    while (true) {
                        System.out.print("Nhập giá mới: ");
                        float price = Float.parseFloat(scanner.nextLine());
                        if (price > 0) {
                            arrProducts[index].setPrice(price);
                            break;
                        }
                        System.out.println("Giá phải > 0!");
                    }
                    System.out.println("✔ Đã cập nhật giá!");
                    break;

                case 3:
                    System.out.print("Nhập mô tả mới: ");
                    arrProducts[index].setDescription(scanner.nextLine());
                    System.out.println("✔ Đã cập nhật mô tả!");
                    break;

                case 4:
                    System.out.println("Danh mục hiện có:");
                    for (int i = 0; i < catalogCount; i++) {
                        System.out.println(arrCategories[i].getCatalogId()
                                + " - " + arrCategories[i].getCatalogName());
                    }
                    System.out.print("Nhập mã danh mục mới: ");
                    arrProducts[index].setCatalogId(
                            Integer.parseInt(scanner.nextLine())
                    );
                    System.out.println("✔ Đã cập nhật danh mục!");
                    break;

                case 5:
                    System.out.print("Nhập trạng thái (0-Bán |1-Hết |2-Không bán): ");
                    arrProducts[index].setProductStatus(
                            Integer.parseInt(scanner.nextLine())
                    );
                    System.out.println("✔ Đã cập nhật trạng thái!");
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }

    static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        int index = findProductIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        for (int i = index; i < productCount - 1; i++) {
            arrProducts[i] = arrProducts[i + 1];
        }
        arrProducts[--productCount] = null;

        System.out.println("Xóa sản phẩm thành công!");
    }

    static void searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String key = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < productCount; i++) {
            if (arrProducts[i].getProductName().toLowerCase().contains(key.toLowerCase())) {
                arrProducts[i].displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy!");
    }

    static void searchProductByPrice(Scanner scanner) {
        System.out.print("Nhập giá a: ");
        float a = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá b: ");
        float b = Float.parseFloat(scanner.nextLine());

        for (int i = 0; i < productCount; i++) {
            float price = arrProducts[i].getPrice();
            if (price >= a && price <= b) {
                arrProducts[i].displayData();
            }
        }
    }
}
