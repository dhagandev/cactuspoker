package com.example.austin.cactuspoker;

public class UpgradeCard {

    static class Upgrade {
        int upgrade_image;
        String upgrade_name;
        int upgrade_value;
        int upgrade_price;

        Upgrade(int img_ref, String name, int value, int price) {
            this.upgrade_image = img_ref;
            this.upgrade_name = name;
            this.upgrade_value = value;
            this.upgrade_price = price;
        }

        public void setUpgrade_image(int upgrade_image) {
            this.upgrade_image = upgrade_image;
        }

        public void setUpgrade_value(int upgrade_value) {
            this.upgrade_value = upgrade_value;
        }

        public void setUpgrade_name(String upgrade_name) {
            this.upgrade_name = upgrade_name;
        }

        public void setUpgrade_price(int upgrade_price) {
            this.upgrade_price = upgrade_price;
        }
    }

    static Upgrade[] upgrade_collection = {
            new Upgrade(R.drawable.poop, "Upgrade 1", 2, 50),
            new Upgrade(R.drawable.pot, "Upgrade 2", 2, 100),
            new Upgrade(R.drawable.potleaf, "Upgrade 3", 3, 150),
    };
}
