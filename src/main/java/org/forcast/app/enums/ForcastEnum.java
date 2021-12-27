/**
 * 
 */
package org.forcast.app.enums;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
public enum ForcastEnum {
	
	Success, Updated, Deleted, Created;
	
	public enum StatusCode {

		Success(200), Updated(402), Deleted(200), Created(201), No_Content(204);

		private int statusValue;

		StatusCode(int statusValue) {
			this.statusValue = statusValue;
		}

		public int getStatusValue() {
			return statusValue;
		}
	}
}
