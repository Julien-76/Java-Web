export interface Engine {
    id: number;
    carburant: string;
    cylindree: number;
    puissance: number;
}

export interface Voiture {
    car_id: number;
    moteur_id: number;
    model: string;
    price: number;
    engine: Engine;
}
