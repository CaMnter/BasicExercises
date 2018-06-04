package com.camnter.basicexercises.design.builder;

/**
 * @author CaMnter
 */

public class BuilderPattern {

    public static void main(String[] args) {
        new Actor.Builder()
            .type("type")
            .sex("sex")
            .face("face")
            .costume("costume")
            .hairstyle("hairstyle")
            .build();
    }


    public static class Actor {

        private final String type;
        private final String sex;
        private final String face;
        private final String costume;
        private final String hairstyle;


        private Actor(Builder builder) {
            this.type = builder.type;
            this.sex = builder.sex;
            this.face = builder.face;
            this.costume = builder.costume;
            this.hairstyle = builder.hairstyle;
        }


        public static class Builder {

            private String type;
            private String sex;
            private String face;
            private String costume;
            private String hairstyle;


            public Builder() {

            }


            public Builder type(String type) {
                this.type = type;
                return this;
            }


            public Builder sex(String sex) {
                this.sex = sex;
                return this;
            }


            public Builder face(String face) {
                this.face = face;
                return this;
            }


            public Builder costume(String costume) {
                this.costume = costume;
                return this;
            }


            public Builder hairstyle(String hairstyle) {
                this.hairstyle = hairstyle;
                return this;
            }


            public Actor build() {
                return new Actor(this);
            }

        }

    }

}
