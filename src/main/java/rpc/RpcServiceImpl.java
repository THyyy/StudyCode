package rpc;

/**
 * @author yuancome
 * @date 2020/9/24
 */

public class RpcServiceImpl implements RpcService {
    @Override
    public String getName(String userId) {
        return "userName"+userId;
    }

    @Override
    public String addUser(String u) {

        System.out.println("add user");
        return null;
    }
}
