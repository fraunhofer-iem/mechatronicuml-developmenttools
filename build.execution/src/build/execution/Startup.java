package build.execution;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable() {
			public void run() {
				
				try {
					BuildExecution.build();
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Failed to Build");
				}
				workbench.close();
				
			}
		});
	}

}
