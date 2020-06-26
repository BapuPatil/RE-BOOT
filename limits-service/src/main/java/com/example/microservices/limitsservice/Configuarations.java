package com.example.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*the configs are picked from the git repo
any changes made to configs from the spring-cloud-config-server-side
are to be commited in the git
simple modification of the prop in the prop file will not make change 
after the modified config files are commited to the repo
the limit-service must be restarted 
because when the limit service is started at first the config values are copied from 
the spring cloud config server 
*/

@ConfigurationProperties("limits-service") //should match the prefixes of configs in git repo
@Component
public class Configuarations {


    /*
    * names provided here must match with the ones in the
    * properties file
    * */
    private int min;
    private int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
