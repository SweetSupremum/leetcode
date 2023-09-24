package medium;

/**
 * {@see https://leetcode.com/problems/koko-eating-bananas/description/}
 *
 * @author SweetSupremum
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        new KokoEatingBananas().minEatingSpeed(new int[]{312884470}, 312884469);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }
        int left = 0;
        int right = maxPile;
        while (left + 1 < right) {
            int bananas = (left + right) / 2;
            double totalHour = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHour += Math.ceil((double) piles[i] / bananas);
            }

            int intTotalHour = (int) totalHour;

            if (intTotalHour <= h) {
                right = bananas;
            }
            if (intTotalHour > h) {
                left = bananas;
            }

        }
        return right;
    }
}
