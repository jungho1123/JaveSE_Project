package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;


public class ManageBook {
    public static void main(String[] args) {
        Publication[] publications = {
                new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
                new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
                new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
                new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
                new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학")
        };
        for (Publication publication: publications ){
            System.out.println(publication);
        }
        System.out.println(publications[2].getPrice());
        modifyPrice(publications[2]);
        System.out.println(publications[2].getPrice());


    }
    public static void modifyPrice(Publication p){
        double rate=0.0;
        if (p instanceof Magazine){
            rate=0.6;
        } else if (p instanceof Novel) {
            rate=0.8;

        } else if (p instanceof ReferenceBook) {
            rate=0.9;
        }
        p.setPrice((int)(p.getPrice()*rate));
    }

}
