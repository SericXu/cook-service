package fun.nnyy.service.impl;

import fun.nnyy.entity.TUser;
import fun.nnyy.mapper.TUserMapper;
import fun.nnyy.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author seric
 * @since 2023-04-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
