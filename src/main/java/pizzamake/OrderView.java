package pizzamake;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OrderView_table")
public class OrderView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private String pizzaname;
        private Long qty;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public String getPizzaname() {
            return pizzaname;
        }

        public void setPizzaname(String pizzaname) {
            this.pizzaname = pizzaname;
        }
        public Long getQty() {
            return qty;
        }

        public void setQty(Long qty) {
            this.qty = qty;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
