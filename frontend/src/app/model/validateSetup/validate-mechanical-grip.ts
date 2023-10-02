export class ValidateMechanicalGrip {
    frontAntiRollBarMin: number;
    frontAntiRollBarMax: number;
    rearAntiRollBarMin: number;
    rearAntiRollBarMax: number;
    brakePower: number;
    brakeBiasMin: number;
    brakeBiasMax: number;
    steerRatioMin: number;
    steerRatioMax: number;
    frontWheelRateMin: number;
    frontWheelRateMax: number;
    rearWheelRateMin: number;
    rearWheelRateMax: number;
    frontBumpStopRateMin: number;
    frontBumpStopRateMax: number;
    rearBumpStopRateMin: number;
    rearBumpStopRateMax: number;
    frontBumpStopRangeMin: number;
    frontBumpStopRangeMax: number;
    rearBumpStopRangeMin: number;
    rearBumpStopRangeMax: number;
    preloadDifferentialMin: number;
    preloadDifferentialMax: number;

    ValidateFrontAntiRollBar(frontAntiRollBar: number) {
        return frontAntiRollBar >= this.frontAntiRollBarMin && frontAntiRollBar <= this.frontAntiRollBarMax;
    }

    ValidateRearAntiRollBar(rearAntiRollBar: number) {
        return rearAntiRollBar >= this.rearAntiRollBarMin && rearAntiRollBar <= this.rearAntiRollBarMax;
    }

    ValidateBrakeBias(brakeBias: number) {
        return brakeBias >= this.brakeBiasMin && brakeBias <= this.brakeBiasMax;
    }

    ValidateSteerRatio(steerRatio: number) {
        return steerRatio >= this.steerRatioMin && steerRatio <= this.steerRatioMax;
    }

    ValidateFrontWheelRate(frontLeftWheelRate: number, frontRightWheelRate: number) {
        return frontLeftWheelRate >= this.frontWheelRateMin && frontLeftWheelRate <= this.frontWheelRateMax
            && frontRightWheelRate >= this.frontWheelRateMin && frontRightWheelRate <= this.frontWheelRateMax;
    }

    ValidateRearWheelRate(rearLeftWheelRate: number, rearRightWheelRate: number) {
        return rearLeftWheelRate >= this.rearWheelRateMin && rearLeftWheelRate <= this.rearWheelRateMax
            && rearRightWheelRate >= this.rearWheelRateMin && rearRightWheelRate <= this.rearWheelRateMax;
    }

    ValidateFrontBumpStopRate(frontLeftBumpStopRate: number, frontRightBumpStopRate: number) {
        return frontLeftBumpStopRate >= this.frontBumpStopRateMin && frontLeftBumpStopRate <= this.frontBumpStopRateMax
            && frontRightBumpStopRate >= this.frontBumpStopRateMin && frontRightBumpStopRate <= this.frontBumpStopRateMax;
    }

    ValidateRearBumpStopRate(rearLeftBumpStopRate: number, rearRightBumpStopRate: number) {
        return rearLeftBumpStopRate >= this.rearBumpStopRateMin && rearLeftBumpStopRate <= this.rearBumpStopRateMax
            && rearRightBumpStopRate >= this.rearBumpStopRateMin && rearRightBumpStopRate <= this.rearBumpStopRateMax;
    }

    ValidateFrontBumpStopRange(frontLeftBumpStopRange: number, frontRightBumpStopRange: number) {
        return frontLeftBumpStopRange >= this.frontBumpStopRangeMin && frontLeftBumpStopRange <= this.frontBumpStopRangeMax
            && frontRightBumpStopRange >= this.frontBumpStopRangeMin && frontRightBumpStopRange <= this.frontBumpStopRangeMax;
    }

    ValidateRearBumpStopRange(frontLeftBumpStopRange: number, frontRightBumpStopRange: number) {
        return frontLeftBumpStopRange >= this.rearBumpStopRangeMin && frontLeftBumpStopRange <= this.rearBumpStopRangeMax
            && frontRightBumpStopRange >= this.rearBumpStopRangeMin && frontRightBumpStopRange <= this.rearBumpStopRangeMax;
    }

    ValidatePreloadDifferential(preloadDifferential: number) {
        return preloadDifferential >= this.preloadDifferentialMin && preloadDifferential <= this.preloadDifferentialMax;
    }
}
