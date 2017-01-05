package object_programming_2.lab9.reflect;

import object_programming_2.lab9.model.Bind;
import object_programming_2.lab9.model.Model1;
import object_programming_2.lab9.model.RateModel;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionInjector {

    private static final String YEARS_FIELD = "LL";

    private Model1 model1;

    public ReflectionInjector(Model1 model1, int[] years, List<RateModel> rateModels) throws Exception {
        this.model1 = model1;

        //TODO przeniesc to do poublicznej metody
        injectYearsToModel(years);
        injectRateModelsToModel(rateModels);
    }

    private void injectYearsToModel(int[] years) throws Exception {
        Class<? extends Model1> modelClass = model1.getClass();
        Field yearsField = modelClass.getDeclaredField(YEARS_FIELD);
        yearsField.setAccessible(true);

        if (yearsField.getAnnotation(Bind.class) != null) {
            yearsField.setInt(model1, years.length);
        }
    }

    private void injectRateModelsToModel(List<RateModel> rateModels) {
        rateModels.forEach(rateModel -> {
            try {
                injectValuesToField(rateModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void injectValuesToField(RateModel rateModel) throws Exception {
        Class<? extends Model1> modelClass = model1.getClass();
        Field yearsField = modelClass.getDeclaredField(rateModel.getLabel());
        yearsField.setAccessible(true);

        if (yearsField.getAnnotation(Bind.class) != null) {
            yearsField.set(model1, rateModel.getValues());
        }

    }

}
