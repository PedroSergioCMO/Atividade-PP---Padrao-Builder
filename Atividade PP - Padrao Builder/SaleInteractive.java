import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleInteractive {
    private String customerName;
    private List<String> items;
    private boolean isTaxable;
    private boolean isGiftWrap;

    public SaleInteractive(SaleBuilder builder) {
        this.customerName = builder.customerName;
        this.items = builder.items;
        this.isTaxable = builder.isTaxable;
        this.isGiftWrap = builder.isGiftWrap;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public boolean isGiftWrap() {
        return isGiftWrap;
    }

    public static class SaleBuilder {
        private String customerName;
        private List<String> items;
        private boolean isTaxable;
        private boolean isGiftWrap;

        public SaleBuilder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public SaleBuilder withItems(List<String> items) {
            this.items = items;
            return this;
        }

        public SaleBuilder withTaxable(boolean isTaxable) {
            this.isTaxable = isTaxable;
            return this;
        }

        public SaleBuilder withGiftWrap(boolean isGiftWrap) {
            this.isGiftWrap = isGiftWrap;
            return this;
        }

        public SaleInteractive build() {
            return new SaleInteractive(this);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String customerName = scanner.nextLine();

        List<String> items = new ArrayList<>();
        String item = "";
        while (!item.equals("fim")) {
            System.out.print("Digite o nome do item (ou 'fim' para terminar): ");
            item = scanner.nextLine();
            if (!item.equals("fim")) {
                items.add(item);
            }
        }

        System.out.print("A venda é taxável? (s/n) ");
        String taxableStr = scanner.nextLine();
        boolean isTaxable = taxableStr.equalsIgnoreCase("s");

        System.out.print("Quer embrulho para presente? (s/n) ");
        String giftWrapStr = scanner.nextLine();
        boolean isGiftWrap = giftWrapStr.equalsIgnoreCase("s");

        SaleInteractive sale = new SaleInteractive.SaleBuilder()
                .withCustomerName(customerName)
                .withItems(items)
                .withTaxable(isTaxable)
                .withGiftWrap(isGiftWrap)
                .build();

        System.out.println("\nVenda criada:");
        System.out.println("Cliente: " + sale.getCustomerName());
        System.out.println("Itens: " + sale.getItems());
        System.out.println("Taxável: " + sale.isTaxable());
        System.out.println("Embrulho de presente: " + sale.isGiftWrap());
    }
}
