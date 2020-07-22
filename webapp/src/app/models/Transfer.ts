import { TransferType } from './enum/TransferType';

/**
 * Represents a batch
 *
 * @export
 * @class Batch
 */
export class Transfer {
    id: number;
    productId: string;
    date: string;
    transferType: TransferType;
    quantity: number;
    unitCost: number;
}
