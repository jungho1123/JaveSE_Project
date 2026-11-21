package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * ManageBook 클래스는 출판물 관리 시스템의 주요 실행 클래스로, 출판물 객체를 생성하고 관리하는 기능을 제공합니다. 이 클래스는 다양한 출판물(잡지, 소설, 참고서)을 생성하고, 출판물 정보를 출력하며, 가격 할인을 적용하고, 통계 분석을 수행합니다.
 * 주요 메서드
 * 1). main 메서드
 * 프로그램의 진입점으로, 다음 작업들을 순차적으로 수행합니다:
 * 출판물 배열 생성 및 초기화
 * 출판물 정보 출력
 * 특정 출판물(3번째 도서)의 가격 변경
 * 통계 분석 실행
 * 2). 출판물 배열 생성 및 초기화
 * 다형성을 활용하여 Publication 타입의 배열에 다양한 하위 클래스(Magazine, Novel, ReferenceBook) 객체들을 저장합니다.
 */
public class ManageBook {
    public static void main(String[] args) {
        Publication[] publications = {
                new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
                new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
                new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
                new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
                new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
                new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
                new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };
        for (int i = 0; i < publications.length; i++) {
            Publication publication = publications[i];
            System.out.println(i + 1 + ":" + publication);

        }
        System.out.println("====가격변경====");
        int prev_price=publications[2].getPrice();
        System.out.println("변경전가격:"+prev_price);
        modifyPrice(publications[2]);
        StatisticsAnalyzer statisticsAnalyzer=new StatisticsAnalyzer();
        statisticsAnalyzer.printStatistics(publications);

    }

    public static void modifyPrice(Publication publication) {
        int cur_price = publication.getPrice();
        if (publication instanceof Magazine) {
            publication.setPrice((int) (cur_price * 0.6));
        } else if (publication instanceof Novel) {
            publication.setPrice((int) (cur_price * 0.8));


        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int) (cur_price * 0.9));

        }
        System.out.println("변경후가격:"+publication.getPrice());
        System.out.println("차액:"+(cur_price-publication.getPrice()));
    }
}
