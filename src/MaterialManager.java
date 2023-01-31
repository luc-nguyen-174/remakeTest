import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class MaterialManager {
    private List<Material> materials = new ArrayList<>();

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void updateMaterial(Material material) {
        int index = materials.indexOf(material);
        materials.set(index, material);
    }

    public void deleteMaterial(Material material) {
        materials.remove(material);
    }

    public List<Material> getMaterials() {
        return materials;
    }
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();

        LocalDate manufacturingDate1 = LocalDate.of(2022, 1, 1);
        LocalDate manufacturingDate2 = LocalDate.of(2022, 2, 1);
        LocalDate manufacturingDate3 = LocalDate.of(2022, 3, 1);
        LocalDate manufacturingDate4 = LocalDate.of(2022, 4, 1);
        LocalDate manufacturingDate5 = LocalDate.of(2022, 5, 1);

        materialManager.addMaterial(new CrispyFlour("CF1", "Bột chiên giòn 1", manufacturingDate1, 10, 10));
        materialManager.addMaterial(new CrispyFlour("CF2", "Bột chiên giòn 2", manufacturingDate2, 20, 20));
        materialManager.addMaterial(new CrispyFlour("CF3", "Bột chiên giòn 3", manufacturingDate3, 30, 30));
        materialManager.addMaterial(new CrispyFlour("CF4", "Bột chiên giòn 4", manufacturingDate4, 40, 40));
        materialManager.addMaterial(new CrispyFlour("CF5", "Bột chiên giòn 5", manufacturingDate5, 50, 50));

        materialManager.addMaterial(new Meat("M1", "Thịt 1", manufacturingDate1, 100, 1));
        materialManager.addMaterial(new Meat("M2", "Thịt 2", manufacturingDate2, 200, 2));
        materialManager.addMaterial(new Meat("M3", "Thịt 3", manufacturingDate3, 300, 3));
        materialManager.addMaterial(new Meat("M4", "Thịt 4", manufacturingDate4, 400, 4));
        materialManager.addMaterial(new Meat("M5", "Thịt 5", manufacturingDate5, 500, 5));

        List<Material> materials = materialManager.getMaterials();
        for (Material material : materials) {
            System.out.println(material.getName() + " " + material.getAmount());
        }

    }

}
