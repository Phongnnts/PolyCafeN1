package poly.cafe.entity;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author admin
 */
public class Revenue {

    @Data
    @Builder
    public static class ByCategory {
        private String category;
        private double revenue;
        private int quantity;
        private double minPrice;
        private double maxPrice;
        private double avgPrice;
    }

    @Data
    @Builder
    public static class ByUser {
        private String user;
        private double revenue;
        private int quantity;
        private Timestamp firstTime;
        private Timestamp lastTime;
    }

}
