package com.example.austin.cactuspoker;

public class ManagerCard {

    static class Manager {
        int manager_image;
        String manager_name;
        String manager_description;
        int manager_price;

        Manager(int img_ref, String name, String desc, int price) {
            this.manager_image = img_ref;
            this.manager_name = name;
            this.manager_description = desc;
            this.manager_price = price;
        }

        public void setManager_image(int manager_image) {
            this.manager_image = manager_image;
        }

        public void setManager_name(String manager_name) {
            this.manager_name = manager_name;
        }

        public void setManager_price(int manager_price) {
            this.manager_price = manager_price;
        }

        public void setManager_description(String manager_description) {
            this.manager_description = manager_description;
        }
    }

    static ManagerCard.Manager[] manager_collection = {
            new ManagerCard.Manager(R.drawable.wrestler, "Manager 1", "desc 1", 50),
            new ManagerCard.Manager(R.drawable.spy, "Manager 2", "desc 2", 100),
            new ManagerCard.Manager(R.drawable.chef, "Manager 3", "desc 3", 150),
    };
}
