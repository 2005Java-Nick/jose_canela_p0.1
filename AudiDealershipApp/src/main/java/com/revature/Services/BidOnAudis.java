package com.revature.Services;

/**
 * @author josecanela
 *
 */
public interface BidOnAudis {
	
		/**
		 * Customer makes an offer for an Audi.
		 * @param userid
		 * @param carid
		 * @param amount
		 */
		public void addOffer(Integer userid, Integer carid, Double amount);
		
		// Employee accepts an offer on an Audi.
		/**
		 * @param offerId
		 */
		public void acceptOffer(String username);
		
		
}
