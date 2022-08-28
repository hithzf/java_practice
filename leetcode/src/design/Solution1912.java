package design;

import java.util.*;

/**
 * Time Exceed Limit版本 o(╥﹏╥)o
 */
public class Solution1912 {

    private final int NUMS = 5;

    private Map<Integer, Map<Integer, MovieRenting>> map = new HashMap<>();

    private TreeSet<MovieRenting> reserved = new TreeSet<>((o1, o2) -> {
        if (o1.price == o2.price) {
            if (o1.shop == o2.shop) {
                return o1.movie - o2.movie;
            }
            return o1.shop - o2.shop;
        }
        return o1.price - o2.price;
    });

    private TreeSet<MovieRenting> rented = new TreeSet<>((o1, o2) -> {
        if (o1.price == o2.price) {
            if (o1.shop == o2.shop) {
                return o1.movie - o2.movie;
            }
            return o1.shop - o2.shop;
        }
        return o1.price - o2.price;
    });

    public Solution1912(int n, int[][] entries) {
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] entry : entries) {
            MovieRenting movieRenting = new MovieRenting(entry[0], entry[1], entry[2]);
            reserved.add(movieRenting);
            map.get(movieRenting.shop).put(movieRenting.movie, movieRenting);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>(NUMS);
        Iterator<MovieRenting> iterator = reserved.iterator();
        while (res.size() < NUMS) {
            if (!iterator.hasNext()) {
                break;
            }
            MovieRenting movieRenting = iterator.next();
            if (movieRenting.movie == movie) {
                res.add(movieRenting.shop);
            }
        }
        return res;
    }

    public void rent(int shop, int movie) {
        MovieRenting renting = map.get(shop).get(movie);
        reserved.remove(renting);
        rented.add(renting);
    }

    public void drop(int shop, int movie) {
        MovieRenting droping = map.get(shop).get(movie);
        rented.remove(droping);
        reserved.add(droping);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>(NUMS);
        Iterator<MovieRenting> iterator = rented.iterator();
        while (res.size() < NUMS) {
            if (iterator.hasNext()) {
                MovieRenting movieRenting = iterator.next();
                List<Integer> shopMovie = new ArrayList<>();
                shopMovie.add(movieRenting.shop);
                shopMovie.add(movieRenting.movie);
                res.add(shopMovie);
            } else {
                break;
            }
        }
        return res;
    }

    private final class MovieRenting {
        private int shop;
        private int movie;
        private int price;

        public MovieRenting(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MovieRenting that = (MovieRenting) o;
            return shop == that.shop &&
                    movie == that.movie &&
                    price == that.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop, movie, price);
        }
    }

    public static void main(String[] args) {
        int[][] input = {{0, 418, 3}, {9, 5144, 46}, {2, 8986, 29}, {6, 1446, 28}, {3, 8215, 97}, {7, 9105, 34}, {6, 9105, 30}, {5, 1722, 94}, {9, 528, 40}, {3, 850, 77}, {3, 7069, 40}, {8, 1997, 42}, {0, 8215, 28}, {7, 4050, 80}, {4, 7100, 97}, {4, 9686, 32}, {4, 2566, 93}, {2, 8320, 12}, {2, 5495, 56}};
        Solution1912 solution1912 = new Solution1912(10, input);
        solution1912.search(7837);
        solution1912.search(5495);
        solution1912.rent(4, 7100);
        solution1912.search(9105);
        solution1912.search(1446);
        solution1912.report();
        solution1912.search(9869);
        solution1912.drop(4, 7100);
    }
}
