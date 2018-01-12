package org.tasks.makers;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyValue;

import org.tasks.data.GoogleTaskList;

import static com.natpryce.makeiteasy.Property.newProperty;
import static org.tasks.makers.Maker.make;

public class GtaskListMaker {

    public static final Property<GoogleTaskList, Long> ID = newProperty();
    public static final Property<GoogleTaskList, Integer> ORDER = newProperty();
    public static final Property<GoogleTaskList, String> REMOTE_ID = newProperty();
    public static final Property<GoogleTaskList, Long> LAST_SYNC = newProperty();
    public static final Property<GoogleTaskList, String> NAME = newProperty();

    public static GoogleTaskList newGtaskList(PropertyValue<? super GoogleTaskList, ?>... properties) {
        return make(instantiator, properties);
    }

    private static final Instantiator<GoogleTaskList> instantiator = lookup -> new GoogleTaskList() {{
        setDeleted(0L);
        setId(lookup.valueOf(GtaskListMaker.ID, 0L));
        setRemoteId(lookup.valueOf(REMOTE_ID, "1"));
        setTitle(lookup.valueOf(NAME, "Default"));
        setRemoteOrder(lookup.valueOf(ORDER, 0));
        setLastSync(lookup.valueOf(LAST_SYNC, 0L));
    }};
}
