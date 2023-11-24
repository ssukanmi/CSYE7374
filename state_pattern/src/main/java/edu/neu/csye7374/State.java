package edu.neu.csye7374;

public class State {
    private interface RestaurantMenuAPI {
        void showLunchMenuDescription();
        void showDinnerMenuDescription();
        void showOptionalMenuDescription();
    }

    private interface RestaurantAPI {
        void showLunchMenuDescription();
        void showDinnerMenuDescription();
        void showOptionalMenuDescription();
    }

    private static class LunchMenuState implements RestaurantMenuAPI {
        private final Restaurant restaurant;

        public LunchMenuState(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public void showLunchMenuDescription() {
            System.out.println(
                    "" +
                    "lunch menu:\n" +
                    "   ITEM    PRICE    DESCRIPTION\n" +
                    "    1         $1.99     hot dog\n" +
                    "    2         $2.99     salad\n" +
                    "    3         $3.99     hamburger"
            );
        }

        @Override
        public void showDinnerMenuDescription() {
            restaurant.setState(restaurant.getDinnerMenu());
            restaurant.showDinnerMenuDescription();
        }

        @Override
        public void showOptionalMenuDescription() {
            System.out.println(
                    "OPTIONAL\n" +
                    "    4         $14.99     salmon\n" +
                    "    5         $15.99     chicken"
            );
        }
    }

    private static class DinnerMenuState implements RestaurantMenuAPI {
        private final Restaurant restaurant;

        public DinnerMenuState(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public void showLunchMenuDescription() {
            System.out.println("Error: Cannot got to Lunch menu from this state.");
        }

        @Override
        public void showDinnerMenuDescription() {
            System.out.println(
                    "dinner menu:\n" +
                    "    1         $11.99     soup\n" +
                    "    2         $12.99     salad\n" +
                    "    3         $13.99     steak"
            );
        }

        @Override
        public void showOptionalMenuDescription() {
            System.out.println(
                    "OPTIONAL\n" +
                    "    4         $14.99     salmon\n" +
                    "    5         $15.99     chicken"
            );
        }
    }

    private static class Restaurant implements RestaurantAPI {
        RestaurantMenuAPI lunchMenu, dinnerMenu, state;

        public Restaurant() {
            this.lunchMenu = new LunchMenuState(this);
            this.dinnerMenu = new DinnerMenuState(this);
            this.state = lunchMenu;
        }

        @Override
        public void showLunchMenuDescription() {
            state.showLunchMenuDescription();
        }

        @Override
        public void showDinnerMenuDescription() {
            state.showDinnerMenuDescription();
        }

        @Override
        public void showOptionalMenuDescription() {
            state.showOptionalMenuDescription();
        }


        public RestaurantMenuAPI getLunchMenu() {
            return lunchMenu;
        }

        public RestaurantMenuAPI getDinnerMenu() {
            return dinnerMenu;
        }

        public void setState(RestaurantMenuAPI state) {
            this.state = state;
        }
    }

    public static void demo() {
        RestaurantAPI restaurant = new Restaurant();

        restaurant.showLunchMenuDescription();
        restaurant.showDinnerMenuDescription();
        restaurant.showOptionalMenuDescription();
    }
}
