export class Car {
    make: string;
    model: string;
    year: number;
    vin: string;
    constructor(make: string, model: string, year: number, vin: string) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

    public getMake(): string {
        return this.make;
    }
    public getModel(): string {
        return this.model;
    }
    public getYear(): number {
        return this.year;
    }
    public getVin(): string {
        return this.vin;
    }

    public setMake(make: string): void {
        this.make = make;
    }
    public setModel(model: string): void {
        this.model = model;
    }
    public setYear(year: number): void {
        this.year = year;
    }
    public setVin(vin: string): void {
        this.vin = vin;
    }

}
