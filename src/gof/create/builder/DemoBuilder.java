package gof.create.builder;


class SuperComputer {
    private String HDD;
    private String RAM;

    //可选
    private boolean isGraphicsCardEnabled;
    private boolean isBlueToothEnabled;

    public SuperComputer(Builder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBlueToothEnabled = builder.isBlueToothEnabled;
    }

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBlueToothEnabled() {
        return isBlueToothEnabled;
    }

    //builder
    public static class Builder {
        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBlueToothEnabled;

        private Builder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public Builder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public Builder setBlueToothEnabled(boolean blueToothEnabled) {
            isBlueToothEnabled = blueToothEnabled;
            return this;
        }

        public static Builder builder(String HDD, String RAM) {
            return new Builder(HDD, RAM);
        }
        public SuperComputer build() {
            return new SuperComputer(this);
        }
    }
}

public class DemoBuilder {
    public static void main(String[] args) {
        SuperComputer superComputer = SuperComputer.Builder.builder("500T", "100G")
                .setGraphicsCardEnabled(true).setBlueToothEnabled(false).build();

        System.out.println(superComputer.getHDD());
        System.out.println(superComputer.isGraphicsCardEnabled());
    }
}
