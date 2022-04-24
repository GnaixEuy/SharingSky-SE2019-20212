package type;

import com.sun.istack.NotNull;
import lombok.*;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * <img src='https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg'/>
 * <p>
 * 项目： bigData-20212
 *
 * @author GnaixEuy
 * @date 2022/4/19
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class BankInfo implements WritableComparable<BankInfo> {

    private String id;
    private String type;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeChars(this.id);
        dataOutput.writeChars(this.type);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readLine();
        this.type = String.valueOf(this.id.charAt(this.id.length()-1));
        this.id = this.id.substring(0,this.id.length()-1);
    }

    @Override
    public int compareTo(BankInfo bankInfo) {
        System.out.println(this.id + "  "+this.type);
        System.out.println(bankInfo.getId() + "----"+this.getType());
        if (this.id.equals(bankInfo.getId())) {
            if (this.type.equals(bankInfo.getType())) {
                return 0;
            } else {
                return this.type.hashCode() > bankInfo.getType().hashCode() ? 1 : -1;
            }
        } else {
            return this.id.hashCode() > bankInfo.getId().hashCode() ? 1 : -1;
        }

    }
}
