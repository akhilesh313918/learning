export class Product {
    
    public id: number;
    public name: string;
    public model: string;
    public company: string;
    public price: number;

    constructor(id: number, name: string, 
        model: string, company: string, price: number ){
        this.id = id;
        this.name = name;
        this.model = model;
        this.company = company;
        this.price = price;
    }
}