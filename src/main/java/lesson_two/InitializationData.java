package lesson_two;

public class InitializationData {


    private Information information;

    public InitializationData() {
        information = new Information();
    }

    public void fillInformation() {
        for (int i = 0; i < 30; i++) {
            information.nickname.add("a" + i + "user");
            information.potentialUserMail.add("a" + i + "mail" + "@email.ua");
            information.nicknameMailRatio.put( information.nickname.get(i),  information.potentialUserMail.last());
        }

        fillWithTheSameInfo();

        if (isCollectionsSizeEqual()){
            System.out.println("\nCollections size is equal");
        } else System.out.println("\nCollections size is NOT equal");
    }

    public void fillWithTheSameInfo() {
        for (int i = 0; i <= 10; i++) {

            if (!information.potentialUserMail.contains("a" + i + "mail" + "@email.ua")){
                information.nickname.add("a" + i + "user");
                information.potentialUserMail.add("a" +  information.nickname.get(i) + "mail" + "@email.ua");
                information.nicknameMailRatio.put( information.potentialUserMail.last(),  information.nickname.get(i));
            } else System.out.println("This user already exists");
        }
    }

    private boolean isCollectionsSizeEqual (){
        return  information.nickname.size() ==  information.potentialUserMail.size()
                &&  information.nicknameMailRatio.size() ==  information.nickname.size();
    }

    //Этот метод чисто для меня, чтоб не запутаться

    public void print() {
        System.out.println( information.nickname);
        System.out.println( information.potentialUserMail);
        System.out.println( information.nicknameMailRatio);
        System.out.println( information.nickname.size() + " " +  information.potentialUserMail.size()
                + " " +  information.nicknameMailRatio.size());
    }

    public Information getInformation() {
        return information;
    }
}
