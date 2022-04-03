package votingapp3.model.dao;

public interface usersDao {
    void dbConnect();
    Boolean log(String hash);
    Object search(int id);
    int vote(int ca_id);
}
