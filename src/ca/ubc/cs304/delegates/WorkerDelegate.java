package ca.ubc.cs304.delegates;

import ca.ubc.cs304.UI.InterfaceUI;
import ca.ubc.cs304.entities.WorkerEntity;

import java.util.List;

public interface WorkerDelegate {
    void returnToMainMenu(InterfaceUI ui);

    List<WorkerEntity> projectSelectedWorkerAttributes(Boolean col1, Boolean col2, Boolean col3);
}
