//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cj.geochat.server.authorization.userdetails;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserDetails extends UserDetails {
    String getOpenCode();
}
