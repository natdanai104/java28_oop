import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Store {
    private final ArrayList<Product> products = new ArrayList<>();

    // เพิ่มสินค้า (เช็คโค้ดซ้ำ)
    public boolean addProduct(Product p) {
        if (findProductByCode(p.getCode()) != null) return false;
        products.add(p);
        return true;
    }

    // ค้นหาสินค้าจากรหัส
    public Product findProductByCode(String code) {
        for (Product p : products) {
            if (p.getCode().equals(code)) return p;
        }
        return null;
    }

    // ดึงข้อมูลสินค้าตาม index (ลำดับที่แสดงผล เริ่มจาก 0)
    public Product getProductByIndex(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        return null;
    }

    // แสดงรายการทั้งหมดพร้อมหมายเลขลำดับ (Row Number)
    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in store.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.print((i + 1) + ". ");
            products.get(i).showInfo();
        }
    }

    // ลบสินค้าตามลำดับแถว (Index)
    public boolean deleteProductByIndex(int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
            return true;
        }
        return false;
    }

    // นับจำนวนแถวข้อมูลทั้งหมด
    public int getProductCount() {
        return products.size();
    }

    // บันทึกข้อมูลลงไฟล์ CSV
    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter out = Files.newBufferedWriter(Path.of(filename), StandardCharsets.UTF_8)) {
            for (Product p : products) {
                out.write(p.getCode() + "," + p.getName() + "," + p.getPrice() + "," + p.getStock());
                out.newLine();
            }
        }
    }

    // โหลดข้อมูลจากไฟล์ CSV
    public void loadFromFile(String filename) throws IOException {
        if (!Files.exists(Path.of(filename))) return; // ถ้ายังไม่มีไฟล์ให้ข้ามไป
        ArrayList<Product> loaded = new ArrayList<>();
        try (BufferedReader in = Files.newBufferedReader(Path.of(filename), StandardCharsets.UTF_8)) {
            String line;
            int row = 0;
            while ((line = in.readLine()) != null) {
                row++;
                if (line.isBlank()) continue;
                String[] a = line.split(",", -1);
                if (a.length != 4) throw new IOException("Invalid column count at line " + row);
                try {
                    Product p = new Product(a[0].trim(), a[1].trim(),
                            Double.parseDouble(a[2].trim()), Integer.parseInt(a[3].trim()));
                    loaded.add(p);
                } catch (IllegalArgumentException e) {
                    throw new IOException("Invalid data at line " + row, e);
                }
            }
        }
        products.clear();
        products.addAll(loaded);
    }
}