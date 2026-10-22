# FIT2099 Roguelike Game Engine: Quota & Credit System

A Java roguelike built on the Monash FIT2099 game engine as a team project (Assignment 3). The player is a contracted worker who visits planets, collects and sells resources, and has to hit a company quota before a deadline.

My part of the team project was **REQ1: the quota and company-credit system**.

## What I implemented

- **`QuotaSystem`**: a map-keyed singleton (`HashMap<GameMap, QuotaSystem>`) so each planet runs its own quota cycle. It tracks company credits, rank, time limit and deadline, and locks out the Supercomputer when the quota is failed. Quota and time-limit increases are ceiling-rounded.
- **`Cuttable` and `CutAction`**: objects such as `AluminiumDoor`, `Overflow20Vent` and `AlienCube` own their own cut logic and expose a `CutAction` only when the actor has the `CUTTER` ability, so there are no `instanceof` checks.
- **`PlasmaCutter`**: a buyable item that grants the `CUTTER` ability and applies burn damage on purchase.
- **`Depositable` and `DepositAction`**: mirrors the existing `Sellable` pattern. `AluminiumScrap`, `IndustrialFan` and `AlienArtifact` each define their own deposit side effects, and `DepositAction` awards company credits.
- **Refactor**: `TransactionSystem` changed from static utility methods to a singleton, fixing an Open/Closed violation raised in Assignment 2 feedback.

## Design decisions

| Decision | Principle |
|---|---|
| `Cuttable` and `Depositable` interfaces follow the existing `Sellable` pattern | OCP, DIP |
| Quota state is keyed per `GameMap` instead of one global singleton | SRP, OCP |
| `hasAbility(CUTTER)` instead of `instanceof` | DIP |
| Each cuttable and depositable owns its behaviour, with no central switch | SRP |

## Testing

12 unit tests cover `QuotaSystem`: credit accumulation, cycle advancement, rank progression, ceiling rounding over multiple cycles, failure state and ticking after failure. Test helpers (`getTestInstance()`, `tickUntilDeadline()`, `tickTestTurn()`) let the quota logic be tested without a live `GameMap`.

Bugs found and fixed along the way:
- Quota cycle did not advance because `tickUntilDeadline()` did not stop after `advanceCycle()`.
- A floating-point error (`200 * 1.10` gave `220.00000000000003`) made `Math.ceil()` return 221 instead of 220.
- `isFailed()` is now checked in every item's `allowableActions()`, so selling and depositing are fully locked after failure.
- Quota no longer ticks or prints on maps with no worker present.

## Project layout

```
src/      game source code
docs/     design documentation
Javadoc/  generated API documentation
```

## Running it

Open the project in IntelliJ IDEA and run the main application class. Requires a recent JDK.

## Context

University coursework for FIT2099 (Object-Oriented Design and Implementation), Monash University Malaysia. Built with a team; this README describes my contribution.
