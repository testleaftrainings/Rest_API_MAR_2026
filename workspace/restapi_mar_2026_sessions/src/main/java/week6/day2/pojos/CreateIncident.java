
package week6.day2.pojos;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CreateIncident {

    @SerializedName("result")
    @Expose
    private Result__1 result;

    public Result__1 getResult() {
        return result;
    }

    public void setResult(Result__1 result) {
        this.result = result;
    }

}
