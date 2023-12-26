package HiFresh.uitl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@AllArgsConstructor
public class Periode {

    private LocalDate start;
    private LocalDate end;

    public boolean isIn(Date date) {
        return date.after(java.sql.Date.valueOf(start)) && date.before(java.sql.Date.valueOf(end));
    }


}
