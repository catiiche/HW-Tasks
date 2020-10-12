package com.ifmo.jjd.Lesson9;

import java.util.Objects;

public class ColouringBook extends Book {

        private int picsCount;

        public ColouringBook(String title, int pageCount, int picsCount) {
            super(title, pageCount);
            this.picsCount = picsCount;
        }

        public int getPicsCount() {
            return picsCount;
        }

        @Override
        public String toString() {
            return "ColouringBook{" +
                    " picsCount=" + picsCount+
                    " pageCount=" + getPageCount() +
                    " title=" + getTitle() +
                    " author=" + getAuthor()+
                    '}';
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColouringBook that = (ColouringBook) o;
        return picsCount == that.picsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(picsCount);
    }
}

