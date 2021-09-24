package DZ10;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private HashMap<Integer, Tovar> tovarShop = new HashMap<>();

    public void insert(Integer id, Tovar tovar) {
        var s = "./src/DZ10/shop.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s, true))) {
            if (tovarShop.keySet().isEmpty() || !tovarShop.containsKey(id)) {
                oos.writeObject(tovarShop.put(id, new Tovar(tovar.getId(), tovar.getName(), tovar.getPrice())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void list() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/DZ10/shop.dat"))) {
            ois.readObject();
            tovarShop.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/DZ10/shop.dat"))) {
            ois.readObject();
            var s = tovarShop.values();
            for (Tovar tovar : s) {
                if (tovar.getId().equals(id)) {
                    tovarShop.values().remove(tovar);
                    break;
                }
            }
            System.out.println();
            tovarShop.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Integer id, String name, Integer price) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/DZ10/shop.dat"))) {
            ois.readObject();
            var s = tovarShop.values();
            for (Tovar tovar : s) {
                if (tovar.getId().equals(id)) {
                    tovar.setName(name);
                    tovar.setPrice(price);
                    break;
                }
            }
            System.out.println();
            tovarShop.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void listUP() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/DZ10/shop.dat"))) {
            ois.readObject();
            tovarShop.values()
                    .stream()
                    .sorted(Comparator.comparing(Tovar::getPrice))
                    .collect(Collectors.toList())
                    .forEach(v -> System.out.println("Value: " + v));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void listDOWN() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/DZ10/shop.dat"))) {
            ois.readObject();
            tovarShop.values()
                    .stream()
                    .sorted(Comparator.comparing(Tovar::getPrice).reversed())
                    .collect(Collectors.toList())
                    .forEach(v -> System.out.println("Value: " + v));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void listNew() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/DZ10/shop.dat"))) {
            ois.readObject();
            tovarShop.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Tovar>comparingByKey().reversed())
                    .forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
