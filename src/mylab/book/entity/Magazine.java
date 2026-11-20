package mylab.book.entity;

/**
 * Publication을 상속받아 잡지 정보를 표현합니다.
 * publishPeriod(발행주기) 속성을 추가로 가집니다.
 * toString()을 오버라이드 하여 잡지 정보를 상세히 표시합니다.
 * 주요 속성:
 * publishPeriod: 발행주기 (예: "월간", "주간")
 */
public class Magazine extends Publication {
    private String publishPeriod;

    public Magazine() {
    }

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    public String getPublishPeriod() {
        return publishPeriod;
    }

    public void setPublishPeriod(String publishPeriod) {
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString(){
        return super.toString() +"잡지 발행주기:"+publishPeriod +","+getPage()+"쪽"+getPrice()+"원,출판일:"+getPublishDate();

    }
}
