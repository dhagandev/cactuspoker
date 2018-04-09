package com.example.austin.cactuspoker;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CactusCard {
    static class Cactus {
        int cactus_image;
        String cactus_name;
        int cactus_price;
        int cactus_value;

        Cactus(int img_ref, String name, int cost, int value) {
            this.cactus_image = img_ref;
            this.cactus_name = name;
            this.cactus_price = cost;
            this.cactus_value = value;
        }

        public void setCactus_image(int cactus_image) {
            this.cactus_image = cactus_image;
        }

        public void setCactus_price(int cactus_price) {
            this.cactus_price = cactus_price;
        }

        public void setCactus_value(int cactus_value) {
            this.cactus_value = cactus_value;
        }

        public void setCactus_name(String cactus_name) {
            this.cactus_name = cactus_name;
        }
    }

    static Cactus[] cactus_collection = {
            new Cactus(R.drawable.cacti1, "Cactus 1", 10,1),
            new Cactus(R.drawable.cacti2, "Cactus 2", 100,8),
            new Cactus(R.drawable.cacti3, "Cactus 3", 150, 47),
    };

}
