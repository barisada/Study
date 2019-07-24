package desingPattern;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        DbClient client = new DbClient(new SelectQuery());
        client.run();

        client.setRepository(new UpdateQuery());
        client.run();

        client.setRepository(new DeleteQuery());
        client.run();


    }

    //템플릿 메소드를 스트레트지 패터이랑 합쳐서 사용
    static class DbClient{
        DbRepository repository;
        public DbClient(DbRepository repository){
            this.repository = repository;
        }

        public void run(){
            repository.runQuery();
        }

        public void setRepository(DbRepository repository) {
            this.repository = repository;
        }
    }

    //전략을 일정 스텝으로 분리할 수 있으면 템플릿 메소드 사용가능
    static abstract class DbRepository{
        abstract void connect();
        abstract void prepareStmt();
        abstract void close();

        public void runQuery(){
            connect();
            prepareStmt();
            close();
        }
    }

    static class SelectQuery extends DbRepository{

        @Override
        void connect() {
            System.out.println("DB 연결");
        }

        @Override
        void prepareStmt() {
            System.out.println("select 쿼리 성공!");
        }

        @Override
        void close() {
            System.out.println("DB 연결 종료");
        }
    }

    static class UpdateQuery extends DbRepository{

        @Override
        void connect() {
            System.out.println("DB 연결");
        }

        @Override
        void prepareStmt() {
            System.out.println("Update 쿼리 성공!");
        }

        @Override
        void close() {
            System.out.println("DB 연결 종료");
        }
    }

    static class DeleteQuery extends DbRepository{

        @Override
        void connect() {
            System.out.println("DB 연결");
        }

        @Override
        void prepareStmt() {
            System.out.println("Delete 쿼리 성공!");
        }

        @Override
        void close() {
            System.out.println("DB 연결 종료");
        }
    }
}
