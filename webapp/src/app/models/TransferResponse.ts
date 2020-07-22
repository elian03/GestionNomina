import { Transfer } from './Transfer';
/**
 * Represents a batch
 *
 * @export
 * @class Batch
 */
export class TransferReponse {
    message: string;
    success: boolean;
    transfer: Transfer;
}
