export class Purchase{
  idPurchase: string;
  name: string;
  phone: string;
  start: string;
  status: string;
  ticket: string;


  static cloneBase(purchase: Purchase): Purchase {
    const clonedPurchase: Purchase = new Purchase();
    clonedPurchase.idPurchase = purchase.idPurchase;
    clonedPurchase.name = purchase.name;
    clonedPurchase.phone = purchase.phone;
    clonedPurchase.start = purchase.start;
    clonedPurchase.status = purchase.status;
    clonedPurchase.ticket = purchase.ticket;
    return clonedPurchase;
  }
}
