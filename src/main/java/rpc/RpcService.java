package rpc;

/**
 * RPC服务接口
 *
 * @author yuancome
 * @date 2020/9/24
 */

public interface RpcService {
    String getName(String userId);

    String addUser(String u);
}
