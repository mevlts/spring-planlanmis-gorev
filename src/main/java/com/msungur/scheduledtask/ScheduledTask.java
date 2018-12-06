package com.msungur.scheduledtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    private int frsayac=1;

    //Her 5 saniyede bir metodun çalışacaktır.
    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        logger.info("(fixedRate) Planlanmış görev " + frsayac++ + " kez çağrıldı." );
    }

    private int fdsayac=1;

    // Metod ilk kez uygulama ayağa kalktıktan 5 saniye sonra çalışacak, daha sonra ise
    // bir önceki çalışması tamamlandıktan 3 saniye sonra tekrar çalışacaktır.
    @Scheduled(fixedDelay = 3000,initialDelay = 5000)
    public void fixedDelay() {
        logger.info("(fixedDelay) Planlanmış görev " + fdsayac++ + " kez çağrıldı." );
    }

    private int cronSayac=1;

    // Metod her 1 dakikada bir, ilk saniye çalışacaktır.
    @Scheduled(cron = "0 * * * * ?")
    public void cronExpression() {
        logger.info("(cronExpression) Planlanmış görev " + cronSayac++ + " kez çağrıldı." );
    }


}
