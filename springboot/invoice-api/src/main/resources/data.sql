insert into invoice (id, customername, customeraddress, customergstnumber,subtotal, cgst,sgst,igst,total)
values(1, 'Ramesh', 'Bhedaghat','23sdf1sdf5', 50, 3, 3, 0, 100);
insert into invoice (id, customername, customeraddress, customergstnumber,subtotal, cgst,sgst,igst,total)
values(2, 'Suresh', 'Ranjhi','23sdf1sdf5', 50, 3, 3, 0, 100);
insert into invoice (id, customername, customeraddress, customergstnumber,subtotal, cgst,sgst,igst,total)
values(3, 'Sharad', 'Adhartal','23sdf1sdf5', 50, 3, 3, 0, 100);
insert into invoice (id, customername, customeraddress, customergstnumber,subtotal, cgst,sgst,igst,total)
values(4, 'Ajay', 'Barghi','23sdf1sdf5', 50, 3, 3, 0, 100);


insert into invoice_item(itemid, productname, hsncode, quantity, price, total, invoice_id)
values(1,'Syrotech ONU', '5241', 1, 750, 750, 1);
insert into invoice_item(itemid, productname, hsncode, quantity, price, total, invoice_id)
values(2,'coupler', '5565', 10, 50, 500, 1);
insert into invoice_item(itemid, productname, hsncode, quantity, price, total, invoice_id)
values(3,'Optical Fiber', '5241', 1, 750, 750, 2);
insert into invoice_item(itemid, productname, hsncode, quantity, price, total, invoice_id)
values(4,'Node', '5565', 10, 50, 500, 2);
insert into invoice_item(itemid, productname, hsncode, quantity, price, total, invoice_id)
values(5,'Node', '5565', 10, 50, 500, 2);
insert into invoice_item(itemid, productname, hsncode, quantity, price, total, invoice_id)
values(6,'SetupBox', '1234', 10, 500, 5000, 2);