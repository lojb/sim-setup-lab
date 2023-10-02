export class ValidateTyres {
    tyrePressureMin: number;
    tyrePressureMax: number;
    frontCamberMin: number;
    frontCamberMax: number;
    rearCamberMin: number;
    rearCamberMax: number;
    frontToeMin: number;
    frontToeMax: number;
    rearToeMin: number;
    rearToeMax: number;
    casterMin: number;
    casterMax: number;

    ValidateTyrePressure(tyrePressure: number) {
        return tyrePressure >= this.tyrePressureMin && tyrePressure <= this.tyrePressureMax;
    }

    ValidateFrontCamber(frontLeftCamber: number, frontRightCamber: number) {
        return frontLeftCamber >= this.frontCamberMin && frontLeftCamber <= this.frontCamberMax
            && frontRightCamber >= this.frontCamberMin && frontRightCamber <= this.frontCamberMax;
    }

    ValidateRearCamber(rearLeftCamber: number, rearRightCamber: number) {
        return rearLeftCamber >= this.rearCamberMin && rearLeftCamber <= this.rearCamberMax
            && rearRightCamber >= this.rearCamberMin && rearRightCamber <= this.rearCamberMax;
    }

    ValidateFrontToe(frontLeftToe: number, frontRightToe: number) {
        return frontLeftToe >= this.frontToeMin && frontLeftToe <= this.frontToeMax
            && frontRightToe >= this.frontToeMin && frontRightToe <= this.frontToeMax;
    }

    ValidateRearToe(rearLeftToe: number, rearRightToe: number) {
        return rearLeftToe >= this.rearToeMin && rearLeftToe <= this.rearToeMax
            && rearRightToe >= this.rearToeMin && rearRightToe <= this.rearToeMax;
    }

    ValidateCaster(casterLeft: number, casterRight: number) {
        return casterLeft >= this.casterMin && casterLeft <= this.casterMax
            && casterRight >= this.casterMin && casterRight <= this.casterMax;
    }
}
